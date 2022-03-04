@GenericGenerator(
        name = StringConstants.ID_GENERATOR,
        strategy = "enhanced-sequence",
        parameters = {
                @Parameter(
                        name = "sequence_name",
                        value = "COMMON_SEQUENCE"
                ),
                @Parameter(
                        name = "initial_value",
                        value = "1000"
                )
        }
)
package by.loiko.filtersbackend.model;

import org.hibernate.annotations.*;
import by.loiko.filtersbackend.StringConstants;
