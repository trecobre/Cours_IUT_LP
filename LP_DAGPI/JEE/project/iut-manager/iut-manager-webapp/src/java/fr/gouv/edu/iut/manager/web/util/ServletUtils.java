/**
 *
 */
package fr.gouv.edu.iut.manager.web.util;

import javax.servlet.ServletRequest;

/**
 * @author vgilles
 *
 */
public class ServletUtils {

    /**
     * Get request parameter with leading and trailing whitespace omitted.
     *
     * @param request current request
     * @param parameterName request parameter name
     * @return request parameter trimed, null if parameter isn't in request or
     * if is empty.
     */
    public static String getParameter(final ServletRequest request,
            final String parameterName) {
        String parameter = request.getParameter(parameterName);
        if (parameter == null) {
            return null;
        }
        parameter = parameter.trim();
        if (parameter.length() < 1) {
            return null;
        }
        return parameter;
    }

    /**
     * Get request parameter with leading and trailing whitespace omitted.
     *
     * @param request current request
     * @param parameterName request parameter name
     * @return request parameter trimed, null if parameter isn't in request or
     * if is empty.
     */
    public static String[] getParameterValues(final ServletRequest request,
            final String parameterName) {
        final String[] values = request.getParameterValues(parameterName);
        if (values == null) {
            return null;
        }
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            if (value == null) {
                continue;
            }
            value = value.trim();
            if (value.length() < 1) {
                value = null;
            }
            values[i] = value;
        }
        return values;
    }
}
