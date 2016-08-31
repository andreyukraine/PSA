package ua.artcode.test.controller;

import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IModeratorPSAControllerImp;
import ua.artcode.model.*;

/**
 * Created by IT on 24.08.2016.
 */
public class IModeratorPSAControllerTest {

    static IModeratorPSAController iModeratorPSAController = new IModeratorPSAControllerImp();
    public static Service[] services = new Service[10];
    public static Company[] companies = new Company[10];
    public static User[] users = new User[10];

    public static void main(String[] args) {

        ModeratorPSA moderatorPSATest = new ModeratorPSA("SergeyPSA","artcode@gmail.com","+380","123456","moderator");
        registerTest(moderatorPSATest.getFullname(),"artcode@gmail.com","+380","123456","moderator",moderatorPSATest);

        Service serviceTest = new Service("Интернет","Подключение интернета");
        Service serviceTest1 = new Service("TV","Подключение каналов");

        //createServiceTest("Интернет","Подключение интернета",serviceTest);
        //editServiceTest(0,serviceTest1);

        //Company company = new Company("Maximum-Net", new Location("Ukraine","Kiev","Address"), "descriptionCompany", null);
        //addCompanyTest(company);

        User user = new User("user@gmail.com", "Andrey","+380","123456","user");
        User user1 = new User("user1@gmail.com", "Grisha","+380","123456","user");
        User user2 = new User("user2@gmail.com", "Kolia","+380","123456","user");


//        addUserTest(user);
//        addUserTest(user1);
//        addUserTest(user2);

        //editUserTest(0, user1);
        //removeUserTest(0, user.getFullname());

        //removeCompanyTest(0, company.getNameCompany());
        //removeServiceTest(0, serviceTest.getNameService());

    }

    //регистрация
    static boolean registerTest(String fullname, String email, String phone, String pass, String role, ModeratorPSA moderatorPSATest){
        ModeratorPSA moderatorPSA = iModeratorPSAController.addModeratorPSA(fullname,email,phone,pass,role);
        boolean booleanrez = moderatorPSA.getFullname().equals(moderatorPSATest.getFullname());
        System.out.printf("res %s, method %s, ex %s = practical %s\n",
                booleanrez , "registerTest", moderatorPSATest.getFullname(), moderatorPSA.getFullname());
        return booleanrez;
    }

    //добавить сервис
//    static boolean createServiceTest(String nameService, String descriptionService, Service serviceInput){
//        Service serviceTest = iModeratorPSAController.createService(nameService,descriptionService);
//        for (int i = 0; i < services.length; i++) {
//            if (services[i] != null) {
//                boolean booleanrez = services[i].getNameService().equals(nameService);
//                System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                        booleanrez, "createServiceTest", nameService, services[i].getNameService());
//                return booleanrez;
//            }
//        }
//        return false;
//    }
    //редактировать сервис
//    static boolean editServiceTest(long serviceId, Service service){
//        Service servicesTest = iModeratorPSAController.editService(0,service);
//        for (int i = 0; (i < services.length) & (services[i] != null) ; i++) {
//            boolean booleanrez = services[i].getNameService().equals(service.getNameService());
//            System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                    booleanrez, "editServiceTest", service.getNameService(), services[i].getNameService());
//            return booleanrez;
//        }
//        return false;
//    }

    //удалить сервис
//    static boolean removeServiceTest(long serviceId, String serviceName){
//        Service[] serviceTest = iModeratorPSAController.removeService(serviceId);
//        for (int i = 0; (i < services.length) & (services[i] != null); i++) {
//            if (services[i].getId() == serviceId) {
//                boolean booleanrez = services[i].getNameService()==null && services[i].getDescriptionService() == null;
//                System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                        booleanrez, "removeServiceTest", serviceName, services[i].getNameService());
//                return booleanrez;
//            }
//        }
//        return  false;
//    }

    //    добавить компанию
    //    static boolean addCompanyTest(Company company){
    //        Company[] companyTest = iModeratorPSAController.addCompany(company);
    //        for (int i = 0; i < companies.length ; i++) {
    //            boolean booleanrez = companies[i].getNameCompany().equals(companyTest[i].getNameCompany());
    //            System.out.printf("res %s, method %s, ex %s = practical %s\n",
    //                    booleanrez, "addCompanyTest", companies[i].getNameCompany(), companyTest[i].getNameCompany());
    //            return booleanrez;
    //        }
    //        return false;
    //    }

    //удалить компанию
    static boolean removeCompanyTest(long companyId, String companyName){
        Company[] companyTest = iModeratorPSAController.removeCompany(0);
        for (int i = 0; (i < companies.length) & (companies[i] != null) ; i++) {
            boolean booleanrez = companies[i].getId() == companyId;
            System.out.printf("res %s, method %s, ex %s = practical %s\n",
                    booleanrez, "removeCompanyTest", companyName, companyTest[i].getNameCompany());
            return booleanrez;
        }
        return false;
    }

    //добавить пользователя
//    static boolean addUserTest(User user){
//        User[] userTest = iModeratorPSAController.addUser(user);
//        for (int i = 0; i < users.length; i++) {
//            boolean booleanrez = users[i].getId() == user.getId();
//            System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                    booleanrez, "addUserTest", userTest[i].getFullname(), user.getFullname());
//            return booleanrez;
//        }
//        return false;
//    }

    //изменить пользователя
//    static boolean editUserTest(long userId, User user){
//        User[] usersTest = iModeratorPSAController.editUser(userId,user);
//        for (int i = 0; i < users.length ; i++) {
//            if (users[i].getId() == userId){
//                boolean booleanrez = users[i].getId() == user.getId();
//                System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                        booleanrez, "editUserTest", users[i].getFullname(), usersTest[i].getFullname());
//                return booleanrez;
//            }
//        }
//        return false;
//    }

    //удалить пользователя
//    static boolean removeUserTest(long userId, String userTest){
//        User[] usersTest = iModeratorPSAController.removeUser(userId);
//        for (int i = 0; (i < users.length) & (users[i] != null); i++) {
//                boolean booleanrez = users[i].getId() == userId;
//                System.out.printf("res %s, method %s, ex %s = practical %s\n",
//                        booleanrez, "removeUserTest", users[i].getFullname(), usersTest);
//                return booleanrez;
//        }
//        return false;
//    }
    //ответить на коментарий
    //    Comment replyToComment(long commentID, Comment comment);
    //удалить комментарий
    //    Comment removeComment(long commentID);

    //посмотреть все компании
    static  boolean listAllCompany(){
        return false;
    }

    //посмотреть все сервисы
    static Service[] listAllService(){
        return null;
    }

}
