//
//  ViewController.m
//  Project4
//
//  Created by Patrick Powers on 5/21/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#define BUTTON_ZERO 0
#define BUTTON_ONE 2
#define BUTTON_TWO 3

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    self.view.backgroundColor = [UIColor whiteColor];
    //Login: 1 Create a UILabel near the top of your screen with teh text "Username:" in it.
    UILabel *username = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 10.0f, 90.0f, 20.0f)];
    if (username != nil) {
        username.text = @"Username:";
        
    }
    [self.view addSubview:username];

    //Login: 2 Create a UITextField to the right of the username label
    UITextField *loginTextField = [[UITextField alloc] initWithFrame:CGRectMake(100.0f, 5.0f, 200.0f, 30.0f)];
    if (loginTextField != nil) {
        loginTextField.borderStyle = UITextBorderStyleRoundedRect;
        [self.view addSubview:loginTextField];
    }
    //Login: 3 Create a rounded rectangle UIButton of any color under the UITextField with the text "Login" on it.
    UIButton *loginButton = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if (loginButton != nil) {
        loginButton.frame = CGRectMake(220.0f, 40.0f, 80.0f, 30.0f);
        [loginButton setTitle:@"Login" forState:UIControlStateNormal];
        [self.view addSubview:loginButton];
    //Login: 5 Add a target to the UIButton to call a function called onClick when the user presses the Login button.    
        [loginButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        loginButton.tag = BUTTON_ZERO;
    }
    //Login: 4 Create another UILabel beneath with the default text "Please Enter Username".
    UILabel *usernamePrompt = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 80.0f, 310.0f, 80.0f)];
    if (usernamePrompt != nil) {
        usernamePrompt.text = @"Please Enter Username";
        usernamePrompt.textAlignment = UITextAlignmentCenter;
        usernamePrompt.textColor = [UIColor whiteColor];
        usernamePrompt.backgroundColor = [UIColor blueColor];
    }
    [self.view addSubview:usernamePrompt];
    
    //Date - this section will display a UIAlertView with the current date and time in it using an NSDate object.
    //Date: 1 Create a UIButton using the rounded rectangle type. Give this button any color you wish.
    UIButton *dateButton = [UIButton buttonWithType:UIButtonTypeRoundedRect];
    if (dateButton != nil) {
        dateButton.frame = CGRectMake(5.0f, 210.0f, 100.0f, 30.0f);
    //Date: 2 Add the text "Show Date" to the button
        [dateButton setTitle:@"Show Date" forState:UIControlStateNormal];
        [self.view addSubview:dateButton];   
        [dateButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        dateButton.tag = BUTTON_ONE;
    }
    
    //Info: 1 Create a UIButton using either the light or dark info type and position it somewhere near the bottom of the screen.
    UIButton *infoButton = [UIButton buttonWithType:UIButtonTypeInfoDark];
    if (infoButton != nil) {
        infoButton.frame = CGRectMake(5.0f, 280.0f, 25.0f, 25.0f);
        [self.view addSubview:infoButton]; 
        [infoButton addTarget:self action:@selector(onClick:) forControlEvents:UIControlEventTouchUpInside];
        infoButton.tag = BUTTON_TWO;
    }
    //Info: 2 Create a UILabel beneath it that contains no initial text.
    UILabel *infoPrompt1 = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 320.0f, 310.0f, 80.0f)];
    if (infoPrompt1 != nil) {
        infoPrompt1.backgroundColor = [UIColor blueColor];
    }
    [self.view addSubview:infoPrompt1];
    }


-(void)onClick:(UIButton*)button
{
    if (button.tag == BUTTON_ZERO) 
    {
        //Login: 6 If the user has not entered any text into the UITextField, display in the UILabel, "Username cannot be empty". Otherwise, display "User: username has been logged in".
        //Login: 7 Hint: NSString has a property called length that tells you how many characters are in the string.
        if (button != nil) {
        UILabel *usernamePrompt1 = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 80.0f, 310.0f, 80.0f)];
        if (usernamePrompt1 != nil) {
            usernamePrompt1.text = @"Username cannot be empty";
            usernamePrompt1.textAlignment = UITextAlignmentCenter;
            usernamePrompt1.textColor = [UIColor whiteColor];
            usernamePrompt1.backgroundColor = [UIColor blueColor];
        }
        [self.view addSubview:usernamePrompt1];
        }
        else {
        UILabel *usernamePrompt1 = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 80.0f, 310.0f, 80.0f)];
        if (usernamePrompt1 != nil) {
            usernamePrompt1.text = @"User: username has logged in";
            usernamePrompt1.textAlignment = UITextAlignmentCenter;
            usernamePrompt1.textColor = [UIColor whiteColor];
            usernamePrompt1.backgroundColor = [UIColor blueColor];
        }
        [self.view addSubview:usernamePrompt1];
        }

    }
    else if (button.tag == BUTTON_ONE)
    {
        //Date: 3 Add an action to the button that when clicked, it will call the same onClick handler you already defined. Make sure to add a tag to the date button so you know which one was pressed.
        NSDate *dateTime = [NSDate date];
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        if (dateFormatter != nil) {
            //Date: 4 Display a UIAlertView with the current date and time displayed in the format seen in the dateAlert graphic in the assets section of this project assignment. You can either format the date and time manually or use the date and time styles. You must use an NSDate object to gather the date and time information.
            [dateFormatter setDateFormat:@"MMM d, yyyy hh:mm:ss aaa zzzz"];
            UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Date & Time" message:[dateFormatter stringFromDate:dateTime] delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
            
            if (alertView != nil) 
            {
                [alertView show];
            }
        }  
    }
    else if (button.tag == BUTTON_TWO) {
        //Info: 3 Hook up an action to the info button to have it call the onClick handler you created earlier.
        //Info: 4 When the button is pressed, have the text "This application was created by: Firstname Lastname" appear in the info UILabel. Please replace firstname lastname with your name.
        UILabel *infoPrompt2 = [[UILabel alloc] initWithFrame:CGRectMake(5.0f, 320.0f, 310.0f, 80.0f)];
        if (infoPrompt2 != nil) {
            infoPrompt2.text = @"This application was created by: Patrick Powers";
            infoPrompt2.numberOfLines = 2; 
            infoPrompt2.textAlignment = UITextAlignmentCenter;
            infoPrompt2.textColor = [UIColor whiteColor];
            infoPrompt2.backgroundColor = [UIColor blueColor];
        }
        [self.view addSubview:infoPrompt2];

        
    }
    
    
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

@end
