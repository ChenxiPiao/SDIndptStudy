package prototypepattern;

import java.util.Hashtable;

public class ClassCache {
	
   private static Hashtable<String, Class> classMap  = new Hashtable<String, Class>();

   public static Class getClass(String classId) {
      Class cachedClass = classMap.get(classId);
      return (Class) cachedClass.clone();
   }

   // for each shape run database query and create class
   // classMap.put(classKey, class);
   // for example, we are adding three classes
   
   public static void loadCache() {
      SoftwareDevelopment softwareDevelopment = new SoftwareDevelopment();
      softwareDevelopment.setClassId("1");
      classMap.put(softwareDevelopment.getClassId(), softwareDevelopment);

      HciUsability hciUsability = new HciUsability();
      hciUsability.setClassId("2");
      classMap.put(hciUsability.getClassId(), hciUsability);

      Capstone capstone = new Capstone();
      capstone.setClassId("3");
      classMap.put(capstone.getClassId(), capstone);
   }
}