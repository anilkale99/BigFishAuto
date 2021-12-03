########################################################
# Author     : Ratnakar Dubey
# Test Plane : ResendVoucherFlow.feature
# Test ID    :
# Test case  :
#########################################################
#@Regression
@Store
Feature: Resend voucher Flow
Scenario Outline: Submit Resend voucher Code Flow
  When User Login to application with "SuperAdminUser" and "SuperAdminPassword".
  And  confirming the error code after login need to remove after issue resolved
  And  User on left side bar navigate to "Vendor Management".
  And  Search and Select Vendor name "<VendorName>" from the vendor list and Select action value "Resend Voucher".
  And  Super User adding Voucher code <VendorColumnNo> of vendor "<VendorName>" in file "<Filename>" with success message"<SuccessMessage>".
  Examples:
  |VendorName|VendorColumnNo|Filename|SuccessMessage|
  |  Woohoo    |     0        |VoucherCode_details.xlsx|Voucher code resent successfully!|
