package Payload;

import Pojo.MainPojo;
import Pojo.SpecificsPojo;
import Pojo.fieldsPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class payloads {

    public String createPayload() throws JsonProcessingException {

        fieldsPojo fieldsData = new fieldsPojo();

        fieldsData.setU_first_name("Virtual");
        fieldsData.setU_catalog_item("62d48841876abd10c1bdbaa5dabb3565");
        fieldsData.setU_last_name("Staff");
        fieldsData.setU_phone("404-600-9371");
        fieldsData.setU_email("srishti.chandela@nagarro.com");
        fieldsData.setU_main_site("917798fe1b653050752ee1db234bcb5e");
        fieldsData.setDescription("Testing API");
        fieldsData.setU_multilingual_support_required2("yes");
        fieldsData.setU_language("urdu");
        fieldsData.setU_relationship_to_student("Cousin");
        fieldsData.setU_alt_contact_info("test text");
        fieldsData.setU_can_we_contact_radio("No");
        fieldsData.setU_how_should_we_contact_you("test");
        fieldsData.setU_use_my_default_site("");
        fieldsData.setU_additional_location("test text Room/Location Information");
        fieldsData.setU_are_you_reporting_on_behalf_of_a_student("No");
        fieldsData.setU_stu_id("233676584");
        fieldsData.setU_site("");
        fieldsData.setU_stu_name("STEPHON CRUZ");
        fieldsData.setU_boolean_1(true);
        fieldsData.setU_technology_type("Software");
        fieldsData.setU_technology_type_app("");
        fieldsData.setU_operating_system_os("");
        fieldsData.setU_impact("");
        fieldsData.setU_urgency("");
        fieldsData.setU_priority("");
        fieldsData.setCmdb_ci("");
        fieldsData.setU_asset_not_found(false);
        fieldsData.setU_asset_tag("");
        fieldsData.setU_asset_serial_number("");
        fieldsData.setU_model("");
        fieldsData.setU_asset_type("");
        fieldsData.setU_asset_mfg("");
        fieldsData.setU_asset_status("");
        fieldsData.setU_imei_sim_id_number("");
        fieldsData.setU_student_address_city("city incident");

        SpecificsPojo specifics = new SpecificsPojo();
        specifics.setU_boolean_1(false);
        specifics.setU_student_address_city("opt specific field");
        specifics.setU_asset_not_found(true);
        specifics.setU_reconnection_req_in("reconnection_non_instructional");
        specifics.setU_room_numbers_and_equipment_s_per_room("");

        fieldsData.setSpecifics_data(specifics);
        MainPojo mainObj=new MainPojo();
        mainObj.setFields(fieldsData);
        ObjectMapper map=new ObjectMapper();
        String finalPayload= map.writerWithDefaultPrettyPrinter().writeValueAsString(mainObj);
        return finalPayload;
    }
}
