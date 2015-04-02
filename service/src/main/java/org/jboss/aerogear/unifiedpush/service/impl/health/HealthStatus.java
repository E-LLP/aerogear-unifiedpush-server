/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.aerogear.unifiedpush.service.impl.health;

import java.util.ArrayList;
import java.util.List;

/**
* Holder for the health status
*/
public class HealthStatus {
    private Status status = Status.OK;
    private String summary;
    private List<HealthDetails> details = new ArrayList<HealthDetails>();

    public void add(HealthDetails healthDetails) {
        if (status.ordinal() < healthDetails.getTestStatus().ordinal()) {
            status = healthDetails.getTestStatus();
        }
        details.add(healthDetails);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<HealthDetails> getDetails() {
        return details;
    }

    public void setDetails(List<HealthDetails> details) {
        this.details = details;
    }
}
