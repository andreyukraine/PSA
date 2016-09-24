package ua.artcode.view.swing;

import ua.artcode.controler.IClientController;
import ua.artcode.controler.IModeratorController;
import ua.artcode.controler.IModeratorPSAController;
import ua.artcode.controler.IWorkerController;
import ua.artcode.model.User;
import ua.artcode.utils.Constants;
import ua.artcode.view.LoginView;
import ua.artcode.view.swing.registration_forms.ClientFrame;
import ua.artcode.view.swing.registration_forms.ModeratorFrame;
import ua.artcode.view.swing.registration_forms.ModeratorPSAFrame;
import ua.artcode.view.swing.registration_forms.WorkerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by IT on 22.09.2016.
 */
public class LoginDialog extends JDialog
{
    private static final long serialVersionUID = 1L;


    public JTextField login;
    public JPasswordField password;
    public JButton btnOk;
    private JLabel incorrectPass;
    private JLabel authorizationLable, authorizationLable1,authorizationLable2;
    private LoginView loginView;
    private IClientController iClientController;
    private IModeratorPSAController iModeratorPSAController;
    private IWorkerController iWorkerController;
    private IModeratorController iModeratorController;

    public LoginDialog(JFrame parent,LoginView loginView, IClientController iClientController, IModeratorPSAController iModeratorPSAController, IWorkerController iWorkerController, IModeratorController iModeratorController)
    {
        super(parent, "Вход в систему");

        // добавляем расположение в центр окна
        getContentPane().add(createGUI(parent, loginView, iClientController, iModeratorPSAController, iWorkerController, iModeratorController));
        // задаем предпочтительный размер
        pack();
        setSize(600, 600);
        setLocationRelativeTo(null);
        // выводим окно на экран
        setVisible(true);

    }


    // этот метод будет возвращать панель с созданным расположением
    private JPanel createGUI(JFrame parent, LoginView loginView, IClientController iClientController, IModeratorPSAController iModeratorPSAController, IWorkerController iWorkerController, IModeratorController iModeratorController)
    {

         String errorSt = "";

        // Создание панели для размещение компонентов
        JPanel panel = BoxLayoutUtils.createVerticalPanel();
        // Определение отступов от границ ранели. Для этого используем пустую рамку
        panel.setBorder (BorderFactory.createEmptyBorder(100,200,300,200));
        // Создание панели для размещения метки и текстового поля логина

        authorizationLable = new JLabel("ModeratorPSA - email: m; pass: m");
        authorizationLable1 = new JLabel("Moderator - email: mc; pass: mc");
        authorizationLable2 = new JLabel("Client - email: c; pass: c");



        JPanel name = BoxLayoutUtils.createHorizontalPanel();
        JLabel nameLabel = new JLabel("Email:");
        name.add(nameLabel);
        name.add(Box.createHorizontalStrut(12));
        login = new JTextField(15);

        name.add(login);
        // Создание панели для размещения метки и текстового поля пароля
        JPanel passwordP = BoxLayoutUtils.createHorizontalPanel();
        JLabel passwrdLabel = new JLabel("Pass:");
        passwordP.add(passwrdLabel);
        passwordP.add(Box.createHorizontalStrut(12));
        password = new JPasswordField(15);
        passwordP.add(password);

        incorrectPass = new JLabel("",SwingConstants.CENTER);

        // Создание панели для размещения кнопок управления
        JPanel flow = new JPanel( new FlowLayout( FlowLayout.RIGHT, 0, 0) );
        JPanel grid = new JPanel( new GridLayout(3,3,5,0));
        btnOk = new JButton("Accept");
        btnOk.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e)  {
                    String loginSt = login.getText();
                    String passSt = String.valueOf(password.getPassword());

                    User user = loginView.showLoginMenu(loginSt,passSt);

                    if (user != null){
                        if (user.getRole().equals(Constants.statusClientRole.MODERATOR_PSA)) {
                            new ModeratorPSAFrame(iModeratorPSAController).setVisible(true);
                            dispose();
                        } else if (user.getRole().equals(Constants.statusClientRole.MODERATOR)) {
                            new ModeratorFrame(iModeratorController).setVisible(true);
                            dispose();
                        } else if (user.getRole().equals(Constants.statusClientRole.WORKER)) {
                            new WorkerFrame(iWorkerController).setVisible(true);
                            dispose();
                        } else {
                            new ClientFrame(iClientController).setVisible(true);
                            dispose();
                        }
                    }else{
                        incorrectPass.setText("invalid login or password");
                        incorrectPass.setForeground(Color.red);
                        new LoginDialog(parent,loginView,iClientController,iModeratorPSAController,iWorkerController,iModeratorController);
                    }
              dispose();
            }
        });
        grid.add(btnOk);

        flow.add(grid);
        // Выравнивание вложенных панелей по горизонтали
        BoxLayoutUtils.setGroupAlignmentX(new JComponent[] { name, passwordP, panel, flow },
                Component.LEFT_ALIGNMENT);
        // Выравнивание вложенных панелей по вертикали
        BoxLayoutUtils.setGroupAlignmentY(new JComponent[] {login, passwordP, nameLabel, passwrdLabel},
                Component.CENTER_ALIGNMENT);
        // Определение размеров надписей к текстовым полям
        GUITools.makeSameSize(new JComponent[] { nameLabel, passwrdLabel } );
        // Определение стандартного вида для кнопок
        GUITools.createRecommendedMargin(new JButton[] { btnOk} );
        // Устранение "бесконечной" высоты текстовых полей
        GUITools.fixTextFieldSize(login);
        GUITools.fixTextFieldSize(password);

        // Сборка интерфейса


        panel.add(incorrectPass);
        panel.add(Box.createVerticalStrut(25));
        panel.add(name);
        panel.add(Box.createVerticalStrut(12));
        panel.add(passwordP);
        panel.add(Box.createVerticalStrut(17));
        panel.add(flow);
        panel.add(Box.createVerticalStrut(40));
        panel.add(authorizationLable);
        panel.add(authorizationLable1);
        panel.add(authorizationLable2);
        // готово
        return panel;
    }


    // тестовый метод для проверки диалогового окна
//    public static void main(String[] args) {
//        new LoginDialog(new JFrame());
//    }
}