package com.spring.demo_project.constant;

/**
 * @author Sombath
 * create at 10/9/23 8:53 PM
 */
public class MessageConstant {

    public static final String SUCCESSFULLY = "Successfully";
    public static final String ALL = "ALL";

    public static class ROLE {
        public final static String ADMIN = "ADMIN";
        public final static String USER = "USER";
        public final static Long USER_ROLE_ID = 2L; // user

        public static final String ROLE_CREATED_SUCCESSFULLY = "Role has been created";
        public static final String ROLE_NOT_FOUND = "Role could not be found";
        public static final String ROLE_UPDATED_SUCCESSFULLY = "Successfully";
        public static final String ROLE_DELETED_SUCCESSFULLY = "Role has been deleted";
    }

    public static class AUTH {
        public final static String ACCOUNT_DEACTIVATE = "Account have been deactivated";
        public final static String EMAIL_ALREADY_EXISTS = "Account Email already exists";
    }

    public static class BLOG {
        public static final String BLOG_HAS_BEEN_CREATED = "Blog has been created";
        public static final String BLOG_HAS_BEEN_UPDATED = "Blog has been updated";
        public static final String CATEGORY_COULD_NOT_BE_FOUND = "Category could not be found";
        public static final String TAGS_COULD_NOT_BE_FOUND = "Tag could not be found: %s";
        public static final String BLOG_COULD_NOT_BE_FOUND = "Blog could not be found";
        public static final String BLOG_HAS_BEEN_DELETED = "Blog has been deleted";
        public static final String BLOG_ID_HAS_BEEN_DO_AN_ACTION = "Blog %1s has been do an action: %2s";
        public static final String FOR_YOU = "FOR_YOU";
        public static final String POPULAR = "POPULAR";
        public static final String BLOG_PUBLIC_AT_IS_REQUIRE = "Blog public at is require";
        public static final String BLOG_HAS_BEEN_DRAFT = "Blog has been draft";
        public static final String BLOG_HAS_BEEN_SCHEDULE = "Blog has been schedule";
        public static final Integer DELETE = 0;
        public static final Integer ACTIVE = 1;
        public static final Integer INACTIVE = 2;
        public static final String BLOG_HAS_BEEN_CREATED_ACTIVE = "Blog has been created active";
        public static final String BLOG_HAS_BEEN_CREATED_INACTIVE = "Blog has been created in active";
        public static final String PUBLISH_AT_CANNOT_BE_IN_PAST = "Publish at cannot be in the past";
        public static final String BLOG_HAS_BEEN_ACTIVATED = "Blog has been active";
        public static final String BLOG_HAS_BEEN_INACTIVATED = "Blog has been inactive";
        public static final String BLOG_UNKNOWN_STATUS = "unknown status";
    }

    public static class CATEGORY {
        public static final String CATEGORY_HAS_BEEN_CREATED = "Category has been created";
        public static final String CATEGORY_HAS_BEEN_UPDATED = "Category has been updated";
        public static final String CATEGORY_COULD_NOT_BE_FOUND = "Category could not be found";
        public static final String CATEGORY_HAS_BEEN_FALSE = "Category has been false";
        public static final String CATEGORY_HAS_BEEN_DELETED = "Category has been deleted";
        public static final String CATEGORY_ID_HAS_BEEN_DO_AN_ACTION = "Category %1s has been do an action: %2s";
        public static final String CATEGORY_STATUS_HAS_BEEN_UPDATE_TO_TRUE = "Category status has been updated to true";
        public static final String CATEGORY_NAME_ALREADY_EXISTS = "Category name already exists";
        public static final String CATEGORY_HAS_BEEN_ACTIVATED = "Category has been active";
        public static final String CATEGORY_HAS_BEEN_INACTIVATED = "Category has been in active";
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 2;
        public static final int DELETE = 0;
        public static final String CATEGORY_UNKNOWN_STATUS = "unknown status";
    }

    public static class TAG {
        public static final String TAG_CREATED_SUCCESSFULLY = "Tag has been created";
        public static final String TAG_NOT_FOUND = "Tag could not be found";
        public static final String TAG_UPDATED_SUCCESSFULLY = "Successfully";
        public static final String TAG_DELETED_SUCCESSFULLY = "Tag has been deleted";
        public static final String TAG_COULD_NOT_DELETE = "Tag could not be delete";
        public static final String TAG_NAME_AND_BLOG_HAS_BEEN_DELETED = "Tag %1s and blog %2s has been deleted";
        public static final String TAG_ALREADY_EXISTS = "Tag name already exists";
    }

    public static class CONTACT {
        public static final String CONTACT_CREATED_SUCCESSFULLY = "Contact has been created";
        public static final String CONTACT_NOT_FOUND = "Contact could not be found";
        public static final String CONTACT_DELETED_SUCCESSFULLY = "Contact has been deleted";
    }

    public static class USER {
        public static final String USER_COULD_NOT_BE_FOUND = "User could not be found";
        public static final String USERNAME_OR_EMAIL_ALREADY_EXIST = "Username or email already exist";
        public static final String FIELD_IS_REQUIRED = "%s is required";
        public static final String CURRENT_PASSWORD_DOES_NOT_MATCH = "Current password does not match";
    }

    public static class TOPIC {
        public static final String TOPIC_COULD_NOT_BE_FOUND = "Topic could not be found";
        public static final String TOPIC_CREATED_SUCCESSFULLY = "Topic has been created";
        public static final String TOPIC_DELETED_SUCCESSFULLY = "Topic has been deleted";
        public static final String SKILL_COULD_NOT_BE_FOUND = "Skill could not been found";
        public static final String TOPIC_HAS_BEEN_UPDATED = "Topic has been updated";
        public static final String TOPIC_ALREADY_EXISTS = "Topic name already exists";
    }

    public static class SKILL {
        public static final String SKILL_COULD_NOT_BE_FOUND = "Skill could not be found";
        public static final String SKILL_CREATED_SUCCESSFULLY = "Skill has been created";
        public static final String SKILL_DELETED_SUCCESSFULLY = "Skill has been deleted";
        public static final String SKILL_HAS_BEEN_UPDATED = "Skill has been updated";
        public static final String SKILL_ALREADY_EXISTS = "Skill name already exists";
        public static final String SKILL_HAS_BEEN_ACTIVATED = "Skill has been active";
        public static final String SKILL_HAS_BEEN_INACTIVATED = "Skill has been in active";
        public static final String SKILL_STATUS_FALSE = "Skill status false";
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 2;
        public static final int DELETE = 0;
        public static final String SKILL_HAS_BEEN_DELETED = "skill has been deleted";
        public static final String SKILL_UNKNOWN_STATUS = "unknown status";
    }

    public static class SLIDE {
        public static final String SLIDE_CREATED_SUCCESSFULLY = "Slide has been create";
        public static final String SLIDE_COULD_NOT_BE_FOUND = "Slide could not be found";
        public static final String SLIDE_HAS_BEEN_UPDATED = "Slide has been updated";
        public static final String SLIDE_DELETED_SUCCESSFULLY = "Slide has been deleted";
        public static final String SLIDE_ALREADY_EXISTS = "Slide title already exists ";
    }

    public static class SUBSKILL {
        public static final String SUBSKILL_CREATED_SUCCESSFULLY = "SubSkill has been create";
        public static final String SUBSKILL_COULD_NOT_BE_FOUND = "SubSkill could not be found";
        public static final String SUBSKILL_HAS_BEEN_UPDATED = "SubSkill has been updated";
        public static final String SUBSKILL_DELETED_SUCCESSFULLY = "SubSkill has been deleted";
        public static final String SUBSKILL_ALREADY_EXISTS = "SubSkill name already exists";
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 2;
        public static final int DELETE = 0;
    }

    public static class PORTFOLIO {
        public static final String STUDENT_COULD_NOT_BE_FOUND = "Student could not be found";
        public static final String PORTFOLIO_CREATED_SUCCESSFULLY = "Portfolio has been create";
        public static final String PORTFOLIO_COULD_NOT_BE_FOUND = "Portfolio could not be found";
        public static final String PORTFOLIO_HAS_BEEN_UPDATED = "Portfolio has been updated";
        public static final String PORTFOLIO_DELETED_SUCCESSFULLY = "Portfolio has been deleted";
        public static final String PORTFOLIO_ALREADY_EXISTS = "Portfolio title already exists";
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 2;
        public static final int DELETE = 0;
        public static final String PORTFOLIO_UNKNOWN_STATUS = "unknown status";
        public static final String PORTFOLIO_STATUS_HAS_BEEN_UPDATE_TO_TRUE = "Portfolio status has been updated to true";

    }
    public static class CERTIFICATE {
        public static final String CERTIFICATE_CREATED_SUCCESSFULLY = "Certificate has been create";
        public static final String CERTIFICATE_COULD_NOT_BE_FOUND = "Certificate could not be found";
        public static final String CERTIFICATE_HAS_BEEN_UPDATED = "Certificate has been updated";
        public static final String CERTIFICATE_DELETED_SUCCESSFULLY = "Certificate has been deleted";
        public static final String CERTIFICATE_ALREADY_EXISTS = "Certificate already exists";
        public static final String STUDENT_COULD_NOT_BE_FOUND= "Student could not be found";
        public static final String CERTIFICATE_UNKNOWN_STATUS= "UNKNOW STATUS";
        public static final String CERTIFICATE_STATUS_HAS_BEEN_UPDATE_TO_TRUE = "Certificate status has been updated to true";
        public static final int ACTIVE = 1 ;
        public static final int INACTIVE = 2 ;
        public static final int DELETE = 0;

    }

    public static class STUDENT{
        public static final String STUDENT_CREATED_SUCCESSFULLY = "Student has been create";
        public static final String STUDENT_COULD_NOT_BE_FOUND = "Student could not be found";
        public static final String STUDENTID_COULD_NOT_BE_FOUND = "StudentId could not be found";
        public static final String STUDENT_HAS_BEEN_UPDATED = "Student has been updated";
        public static final String STUDENT_DELETED_SUCCESSFULLY = "Student has been deleted";
        public static final String STUDENTID_ALREADY_EXISTS = "StudentId already exists";
        public static final String STUDENT_EMAIL_ALREADY_EXISTS = "Student email already exists";
        public static final String CANNOT_DELETE_STUDENT_WITH_CERTIFICATE_OR_PORTFOLIO = "Cannot delete student with certificate or portfolio";
        public static final String STUDENT_STATUS_HAS_BEEN_UPDATE_TO_TRUE = "Student status has been update to true";
        public static final int ACTIVE = 1;
        public static final int INACTIVE = 2;
        public static final int DELETE = 0;
        public static final String STUDENT_UNKNOWN_STATUS = "unknown status";
        public static final String STUDENT_USERNAME_ALREADY_EXISTS = "Student username already exists";
        public static final String TRUE = "true";
        public static final String FALSE = "false";
    }
}
