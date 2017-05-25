/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.application.mgt.api.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.device.application.mgt.core.services.impl.ApplicationManagementServiceFactory;

/**
 * Holds util methods required for Application-Mgt API component.
 */
public class ApplicationMgtAPIUtil {

    private static Log log = LogFactory.getLog(ApplicationMgtAPIUtil.class);

    public static ApplicationManagementServiceFactory getApplicationManagementServiceFactory() {
        PrivilegedCarbonContext ctx = PrivilegedCarbonContext.getThreadLocalCarbonContext();
        ApplicationManagementServiceFactory applicationManagerServiceFactory =
                (ApplicationManagementServiceFactory) ctx.getOSGiService(ApplicationManagementServiceFactory.class, null);
        if (applicationManagerServiceFactory == null) {
            String msg = "Application Management provider service has not initialized.";
            log.error(msg);
            throw new IllegalStateException(msg);
        }
        return applicationManagerServiceFactory;
    }
}
