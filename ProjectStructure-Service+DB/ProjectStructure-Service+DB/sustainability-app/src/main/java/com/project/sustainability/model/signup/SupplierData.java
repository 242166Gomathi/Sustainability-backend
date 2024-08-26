//package com.project.sustainability.model.signup;
//
//import com.project.sustainability.constants.SupplierConstants;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Represents supplier data.
// */
//@Data
//@AllArgsConstructor
//@Document(collection = "suppliers_datas")
//public class SupplierData {
//
//        @Id
//        private String id;
//
//        @NotBlank(message = SupplierConstants.COMPANY_NAME_REQUIRED)
//        private String companyName;
//
//        @NotBlank(message = SupplierConstants.ADDRESS_LINE1_REQUIRED)
//        private String addressLine1;
//
//        private String addressLine2;
//
//        @NotBlank(message = SupplierConstants.STATE_REQUIRED)
//        private String state;
//
//        @NotBlank(message = SupplierConstants.COUNTRY_REQUIRED)
//        private String country;
//
//        @NotBlank(message = SupplierConstants.ZIPCODE_REQUIRED)
//        @Size(min = 6, max = 6, message = SupplierConstants.ZIPCODE_LENGTH)
//        private String zipcode;
//
//        private List<ContactDetails> contactDetails;
//        private List<SupplierId> supplierIds;
//
//        /**
//         * Initializes a new SupplierData with a generated UUID.
//         */
//        public SupplierData() {
//                this.id = UUID.randomUUID().toString();
//        }
//}
package com.project.sustainability.model.signup;

import com.project.sustainability.constants.SupplierConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "suppliers_datas")
public class SupplierData {

        @Id
        private String id;

        @NotBlank(message = SupplierConstants.COMPANY_NAME_REQUIRED)
        private String companyName;

        @NotBlank(message = SupplierConstants.ADDRESS_LINE1_REQUIRED)
        private String addressLine1;

        private String addressLine2;

        @NotBlank(message = SupplierConstants.STATE_REQUIRED)
        private String state;

        @NotBlank(message = SupplierConstants.COUNTRY_REQUIRED)
        private String country;

        @NotBlank(message = SupplierConstants.ZIPCODE_REQUIRED)
        @Size(min = 6, max = 6, message = SupplierConstants.ZIPCODE_LENGTH)
        private String zipcode;

        private List<ContactDetails> contactDetails;
        private List<SupplierId> supplierIds;

        public SupplierData() {
                // Default constructor
        }
}
