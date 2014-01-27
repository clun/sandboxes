package fr.clunven.profiler.log;

import java.lang.reflect.Method;
import java.util.HashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Permet de logger des elements d'execution de methode.
 *
 * @author clunven
 */
public class AuditUtils {
	
	/** Logger pour la classe. */
	private static final Log LOGGER = LogFactory.getLog(AuditUtils.class);
    
	/** SimpleType. */
    private static final HashSet < Class < ? > > WRAPPER_TYPES = initWrapperTypes();
    
    /**
     * Liste des types primitifs.
     * @return
     * 		list des types primitifs
     */
    private static HashSet<Class<?>> initWrapperTypes() {
        HashSet<Class<?>> ret = new HashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(String.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        return ret;
    }
	
	/** Classe utilitaire sans constructeur public. */
	private AuditUtils() {
	}
	
	public static void logParameters(String className, String methodName, Object[] pParameter, boolean detailedInspect) {
		// Parameters 
		if (LOGGER.isDebugEnabled()) {
			
            if (pParameter != null) {
                for (int i = 0; i < pParameter.length; i++) {
                    StringBuilder beginLog = new StringBuilder(" + Params #");
                    beginLog.append(i);
                    beginLog.append(" (");
                    if (pParameter[i] != null) {
                        beginLog.append(pParameter[i].getClass().getCanonicalName());
                    } else {
                        beginLog.append("null");
                    }
                    beginLog.append(") : ");
                    beginLog.append(pParameter[i]);
                    LOGGER.debug(beginLog);
                    if (detailedInspect && !WRAPPER_TYPES.contains(pParameter[i].getClass())) {
                    	try {
							inspect(1, pParameter[i]);
						} catch (Exception e) {
							LOGGER.warn("Cannot inspect parameter..." + e.getMessage());
						}
                    }
                }
            }
        }
	}
	
	public static void logOutPut(Object returnedValue, boolean detailedInspect) {
		if (LOGGER.isDebugEnabled()) {
        	if (returnedValue != null) {
        		LOGGER.debug(" + Returned value : '" + returnedValue + "'");
        		if (detailedInspect && !WRAPPER_TYPES.contains(returnedValue.getClass())) {
                 try {
				   inspect(1,returnedValue);
				 } catch (Exception e) {
				   LOGGER.warn("Cannot inspect parameter..." + e.getMessage());
				 }
                }
        	}
        }
	}
	
	/**
	 * Allow to get some details about the Bean.
	 * 
	 * @param obj
	 *            objet to MAP.
	 * @return string representing information about beans.
	 */
	private static void inspect(int idx, final Object obj) throws Exception {
		if (obj != null && idx < 10) {
			for (Method m : obj.getClass().getMethods()) {
				// accessors have no parameters
				if (m.getParameterTypes().length == 0) {
					// As most fields are private we must loop over getters
					if (m.getName().startsWith("get") && !"getClass".equals(m.getName())) {
						StringBuilder builder = new StringBuilder();
						for(int i=0;i<2*idx;i++) {
							builder.append(" ");
						}
						builder.append("- attribute: \'");
						builder.append(m.getName().substring(3, 4).toLowerCase());
						builder.append(m.getName().substring(4));
						Object oo = m.invoke(obj, new Object[0]);
						builder.append("\'\t value:\'" + oo + "\'");
						LOGGER.debug(builder.toString());
						if (null != oo && !WRAPPER_TYPES.contains(oo.getClass())) {
							inspect(idx+1, oo);
						}
					}
					// Boolean attributes got getters starting with 'is'
					if (m.getName().startsWith("is")) {
						StringBuilder builder = new StringBuilder();
						builder.append("   - attribute: \'");
						builder.append(m.getName().substring(2, 3).toLowerCase());
						builder.append(m.getName().substring(3));
						builder.append("\'\t value:\'" + m.invoke(obj, new Object[0]) + "\'");
						LOGGER.debug(builder.toString());
					}
				}
			}
		}
	}
	
}
