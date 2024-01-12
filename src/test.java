/*
	java login form
*/

class MyFrame extends java.awt.Frame implements java.awt.event.ActionListener
{
	static java.awt.Panel center_Panel, north_Panel;

	static java.awt.TextField username_field, password_field;

	static java.awt.Button login_button;

	/* constructor */

    MyFrame()
    {
        this.setBounds(100,100,500,500);

        /* center Panel */

        center_Panel = new java.awt.Panel();

        center_Panel.setLayout(null);

        	/* username field */

			username_field = new java.awt.TextField();

			username_field.setBounds(150,150,200,50);

			/* password field */

			password_field = new java.awt.TextField();

			password_field.setBounds(150,250,200,50);

			/* login button */

			login_button = new java.awt.Button();

			login_button.setLabel("Login");

			login_button.setBounds(150,350,200,50);

			login_button.addActionListener(this);

		center_Panel.add(username_field);

		center_Panel.add(password_field);

		center_Panel.add(login_button);

        this.add(center_Panel);
    }

    public void actionPerformed(java.awt.event.ActionEvent event)
    {
		System.out.println(" todo logined code ");
    }
}

class Test
{
    public static void main(String[] args)
    {
        System.out.println("execute");

        new MyFrame().setVisible(true);
    }
}
