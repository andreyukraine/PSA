package ua.artcode.test.controller;

import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorControllerImp;
import ua.artcode.model.*;

public class IModeratorControllerTest {


//    //TODO test
//    static IModeratorController iModeratorController = new IModeratorControllerImp();
//
//    public static void main(String[] args) {
//        Moderator moderator = new Moderator("Andrey", "a.webears@gmail.com","2329382","123456", "moderator");
//        Company company = new Company("Рога&Копыта", null, "descriptionCompany", moderator);
//        company.setId(0);
//        Service service = new Service("Телефония", "настройка телефонной связи");
//        Service service1 = new Service("Телефония", "настройка телефонной связи");
//        Service service2 = new Service("IT", "настройка компьютерной сети");
//        Service service3 = new Service("оповещение", "установка оповешение в офисе");
//
//        User worker = new Worker("Rab", "rab@gmail.com", "3049349", "2344", "Разноробочий");
//        Worker worker1 = new Worker("Ivko", "ivko@gmail.com", "34549349", "87844", "Разноробочий");
//        worker1.setCompany(company);
//        Worker worker2 = new Worker("Narkosha", "narkosha@gmail.com", "3459349", "78744", "Разноробочий");
//        worker2.setCompany(company);
//        Client client = new Client("Vnya", "vanya@gmail.com", "33434", "23423", "client");
//        Order order = new Order(2, service, client, "настроить АТС Панасоник");
//        //тестирование метода регистрации
//        testRegister(moderator);
//        testAddCompany(company);
//        testEditCompany(company);
//        testFindCompany(company);
//        testRemoveCompany(company);
//        testAddService(company, service);
//        testRemoveService(service3);
//        testChooseService(service1, service2, service3);
//        testCreateWorker(worker);
//        testAddWorkerToCompany(company, worker);
//        testAsignOrderWorker(order, worker);
//        //метод нуждается в доработке
//        // testGetOwnWorkersInCompany(company, worker1, worker2);
//        testAsignServiceWorker(service, worker1);
//        testAsignServiceWorker(service, worker1);
//    }
//
//
//    static void testRegister(Moderator moderator){
//
//        // проверка создания обьекта с указанными параметрами
//        Moderator excepted = moderator;
//        Moderator practical = iModeratorController.addModeratorPSA(moderator.getFullname(), moderator.getEmail(), moderator.getPhone(), moderator.getPass(), moderator.getRole());
//        boolean res1 = excepted.getFullname().equals(practical.getFullname()) &&
//                    excepted.getEmail().equals(practical.getEmail()) &&
//                    excepted.getPhone().equals(practical.getPhone()) &&
//                    excepted.getPass().equals(practical.getPass()) &&
//                    excepted.getRole().equals(practical.getRole());
//
//
//
//        // Проверка на указание пустого поля имени, эмейла, телефона, пароля или роли
//       Moderator excepted1 = null;
//       Moderator pract0 = iModeratorController.addModeratorPSA("","a.webears@gmail.com","2329382","123456", "moderator");
//        Moderator pract1 = iModeratorController.addModeratorPSA("Andrey","","2329382","123456", "ssd");
//       Moderator pract2 = iModeratorController.addModeratorPSA("Andrey","a.webears@gmail.com","","123456", "moderator");
//        Moderator pract3 = iModeratorController.addModeratorPSA("Andrey","a.webears@gmail.com","2329382","", "moderator");
//        Moderator pract4 = iModeratorController.addModeratorPSA("Andrey","a.webears@gmail.com","2329382","", "");
//
//        boolean res2 = pract0 == null &&
//                        pract1 == null &&
//                        pract2 == null &&
//                        pract3 == null &&
//                        pract4 == null;
//
//        System.out.printf("Result %s, test %s",
//                res1, "metod addModeratorPSA\n");
//        System.out.printf("Result %s test %s",
//                res2, " metod addModeratorPSA for empty String parameter\n");
//    }
//
//        static void testAddCompany(Company company){
//
//            boolean expected = true;
//            boolean practical = iModeratorController.addCompany(company);
//
//            System.out.printf("Result %s test %s expected %s practical %s\n",
//                    expected == practical, " metod addCompany", expected, practical);
//
//            Company testCompany = null;
//            boolean expected1 = false;
//            boolean practical1 = iModeratorController.addCompany(testCompany);
//            System.out.printf("Result %s test %s expected %s practical %s\n",
//                    expected1 == practical1, " metod addCompany for null", expected1, practical1);
//
//        }
//
//
//        static void testEditCompany(Company company){
//
//            String oldName = company.getNameCompany();
//            Company newCompany = iModeratorController.editCompany(oldName, "Bowls");
//            boolean res = false;
//            if (newCompany != null) {
//                res = oldName.equals(newCompany.getNameCompany());
//            }
//            System.out.printf("Result %s test %s expected %s practical %s\n",
//                    !res, " metod editCompany", oldName, newCompany != null ? newCompany.getNameCompany() : "null");
//
//            boolean res2 = false;
//            Company newCompany1 = iModeratorController.editCompany(oldName, "");
//            if (newCompany != null) {
//                res2 = oldName.equals(newCompany1.getNameCompany());
//            }
//            System.out.printf("Result %s test %s expected %s practical %s\n",
//                    !res, " metod editCompany for empty value", "Bowls", newCompany1 != null ? newCompany1.getNameCompany() : "null");
//
//        }
//
//        static void testFindCompany(Company company){
//
//           Company resCompany = iModeratorController.findCompany(company.getId());
//
//            System.out.printf("Result %s test %s expected %s practical %s\n",
//                    resCompany == company, " metod finfCompany ", company.getNameCompany(), resCompany != null ? resCompany.getNameCompany(): "null");
//
//        }
//
//        static void testRemoveCompany(Company company){
//
//            boolean expected = true;
//            boolean practical = iModeratorController.removeCompany(company.getId());
//
//            System.out.printf("Result %s test %s expected %s practical %s\n",
//                    expected == practical, " metod removeCompany", expected, practical);
//
//
//        }
//
//
//    static void testAddService(Company company, Service service){
//
//        boolean expected = true;
//        boolean practical = iModeratorController.addService(company.getId(), service);
//
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                expected == practical, " metod addService", expected, practical);
//
//        Service testService = null;
//        boolean expected1 = false;
//        boolean practical1 = iModeratorController.addService(company.getId(), testService);
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                expected1 == practical1, " metod addService for null", expected1, practical1);
//
//    }
//
//
//    static void testRemoveService(Service service){
//        String oldName = service.getNameService();
//        long id = service.getId();
//        // результат метода удаления сервиса
//        boolean res1 = iModeratorController.removeService(service.getId());
//        boolean res2 = true;
//        // проверка удалился ли сервис путем сверки имени по индексу
//        if (service != null){
//                 if (oldName.equals(service.getNameService())) {
//                     res2 = false;
//                 }
//        }
//
//        boolean res = res1 && res2;
//
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                res, " metod AsignOrderWorker ", "true", res);
//
//    }
//
//    static void testChooseService(Service service1, Service service2, Service service3){
//
//        Service[] testArray = iModeratorController.chooseService(service1, service2, service3);
//        boolean result;
//        if (testArray != null) {
//            int size = testArray.length;
//            boolean[] res = new boolean[size];
//            for (int i = 0; i < testArray.length; i++) {
//                if (testArray != null) {
//                    res[i] = service1.equals(testArray[i]);
//                } else res[i] = false;
//            }
//            result = res[0] &&
//                    res[1] &&
//                    res[2];
//
//        } else result = false;
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                result, " metod chooseservice ", "true", result);
//    }
//
//
//    static void testCreateWorker(User worker){
//
//        // проверка создания обьекта с указанными параметрами
//        User excepted = worker;
//        boolean res1;
//        User practical = iModeratorController.createWorker(worker.getFullname(), worker.getEmail(), worker.getPhone(), worker.getPass());
//        if (practical == null){
//        res1 = false;
//            } else {
//                    res1 = excepted.getFullname().equals(practical.getFullname()) &&
//                    excepted.getEmail().equals(practical.getEmail()) &&
//                    excepted.getPhone().equals(practical.getPhone()) &&
//                    excepted.getPass().equals(practical.getPass());
//            }
//
//
//        // Проверка на указание пустого поля имени, эмейла, телефона, пароля или роли
//        //User excepted1 = null;
//        User pract0 = iModeratorController.createWorker("","a.webears@gmail.com","2329382","123456");
//        User pract1 = iModeratorController.createWorker("Andrey","","2329382","123456");
//        User pract2 = iModeratorController.createWorker("Andrey","a.webears@gmail.com","","123456");
//        User pract3 = iModeratorController.createWorker("Andrey","a.webears@gmail.com","2329382","");
//
//        boolean res2 = pract0 == null &&
//                pract1 == null &&
//                pract2 == null &&
//                pract3 == null;
//
//        System.out.printf("Result %s, test %s",
//                res1, "metod createWorker\n");
//        System.out.printf("Result %s test %s",
//                res2, " metod createWorker for empty String parameter\n");
//    }
//
//    static void testAddWorkerToCompany(Company company, User worker){
//
//        boolean res = iModeratorController.addWorkerToCompany(company.getId(), worker.getId());
//
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                res, " metod AsignOrderWorker ", "true", res);
//
//    }
//
//    static void testAsignOrderWorker(Order order, User worker){
//
//        Worker workerWithOrder = iModeratorController.asignOrderWorker(order, worker.getId());
//        boolean res = false;
//        if (workerWithOrder != null) {
//            Order[] ordersWorker = new Order[workerWithOrder.getOrders().length];
//            ordersWorker = workerWithOrder.getOrders();
//            // проверка добавился ли заказ в список заказов работника, путем сверки номера ордера с номерами ордеров что в списке у работника
//            for (int i = 0; i < ordersWorker.length; i++) {
//                if (ordersWorker[i].getNumberOrder().equals(order.getNumberOrder())){
//                    res = true;
//                }
//            }
//
//        }
//
//
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                res, " metod AsignOrderWorker ", "true", res);
//
//    }
//
//
//
//    // не проверен, нуждается в доработке
//   /* static void testGetOwnWorkersInCompany(Company company, Worker worker1, Worker worker2){
//
//        Worker [] arrayWorker = new Worker[2];
//        arrayWorker = iModeratorController.getOwnWorkersInCompany(company.getId());
//        boolean result  = false;
//        if (arrayWorker != null){
//            boolean [] res = new boolean[arrayWorker.length];
//            for (int i = 0; i < arrayWorker.length; i++) {
//                res[i] = worker1.equals(arrayWorker[i]);
//            }
//
//            result = res [0] &&
//                        res [1];
//
//        }
//
//        System.out.printf("Result %s test %s expected %s practical %s\n",
//                result, " metod getOwnWorkers ", "true", result);
//    }*/
//
//
//    static void testAsignServiceWorker(Service service, Worker worker){
//
//        boolean res = iModeratorController.asignServiceWorker(service, worker);
//
//        // проверка, назначе ли сервису работник
//      /* boolean res2 = false;
//       Service [] testService = worker.getServices();
//        for (int i = 0; i < testService.length; i++) {
//            if (testService.equals(worker.getServices())) {
//                res2 = true;
//                break;
//            }
//        }*/
//
//       System.out.printf("Result %s test %s expected %s practical %s\n",
//                res, " metod testAsignServiceWorker ", "true", res);
//
//    }
//

}
