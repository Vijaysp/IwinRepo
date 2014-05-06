package com.iwin.utility;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.iwin.domain.Prediction;

public class CollectionUtils
{
	static class PerdictionComparator implements Comparator
	{
		public int compare(Object o1, Object o2)
		{
			Prediction prediction1 = (Prediction) o1;
			Prediction prediction2 = (Prediction) o2;
			
			return prediction1.getAverage().compareTo(prediction2.getAverage());
		}
	}
	
	public static Collection sortPredictionAvg(ArrayList col, String sortOrder)
	{
		if (ListConst.LSTSortCollectionOrder.LST_SORT_COLLECTION_ORDER_ASC.
				equals(sortOrder))
		{
			Collections.sort(col, new PerdictionComparator());
		}
		else if (ListConst.LSTSortCollectionOrder.
				LST_SORT_COLLECTION_ORDER_DESC.equals(sortOrder))
		{
			Collections.sort(col, Collections.reverseOrder(
					new PerdictionComparator()));
		}
		else
		{
			System.err.println("Invalid sorting order");
		}
		
		return col;
	}
	
	public static Collection sortCollection(ArrayList col, String field, 
			String sortOrder)
	{
		final String GET_METHOD_PREFIX = "get";
		
		UtilComparator comparator = new UtilComparator(GET_METHOD_PREFIX+field);
		
		if (ListConst.LSTSortCollectionOrder.LST_SORT_COLLECTION_ORDER_ASC.
				equals(sortOrder))
		{
			Collections.sort(col, comparator);
		}
		else if (ListConst.LSTSortCollectionOrder.
				LST_SORT_COLLECTION_ORDER_DESC.equals(sortOrder))
		{
			Collections.sort(col, Collections.reverseOrder(comparator));
		}
		else
		{
			System.err.println("Invalid sorting order");
		}
		
		return col;
	}
	
	static class UtilComparator implements Comparator
	{
		String sortOrder = null;
		String comparableMethod = null;
		
		public UtilComparator(String comparableMethod)
		{
			this.comparableMethod = comparableMethod;
		}
		
		public int compare(Object object1, Object object2)
		{
			int zero = 0;
			Date dateValue1 = null;
			Date dateValue2 = null;
			Object obj1 = null;
			Object obj2 = null;
			Integer intValue1 = null;
			Integer intValue2 = null;
			BigDecimal bigDecimalValue1 = null;
			BigDecimal bigDecimalValue2 = null;
			String stringValue1 = null;
			String stringValue2 = null;
			Method objMethod = null;

			try
			{
				objMethod = object1.getClass().getMethod(comparableMethod, 
						null);

				obj1 = objMethod.invoke(object1, null);
				obj2 = objMethod.invoke(object2, null);

				if (obj1 == null && obj2 != null)
				{
					return 1;
				}
				else if (obj1 != null && obj2 != null)
				{
					if (obj1 instanceof Integer)
					{
						intValue1 = (Integer) obj1;
						intValue2 = (Integer) obj2;

						return (intValue1.
								compareTo(intValue2));
					}
					else if (obj1 instanceof BigDecimal)
					{
						bigDecimalValue1 = (BigDecimal) obj1;
						bigDecimalValue2 = (BigDecimal) obj2;

						return (bigDecimalValue1.
								compareTo(bigDecimalValue2));
					}
					else if (obj1 instanceof String)
					{
						stringValue1 = (String) obj1;
						stringValue2 = (String) obj2;

						return (stringValue1.
								compareTo(stringValue2));
					}
					else if (obj1 instanceof Date)
					{
						dateValue1 = (Date) obj1;
						dateValue2 = (Date) obj2;

						return (dateValue1.
								compareTo(dateValue2));
					}
					else
					{
						return zero;
					}
				}
				else
				{
					return zero;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return 0;
		}
	}
}	
