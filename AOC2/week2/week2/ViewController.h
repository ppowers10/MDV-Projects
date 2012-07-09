//
//  ViewController.h
//  week2
//
//  Created by Patrick Powers on 7/8/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
{
    //where the input is displayed
    IBOutlet UILabel *calc;
    IBOutlet UILabel *newCalc;
    
    //switch
    IBOutlet UISwitch *switchOne;
    
}
//the click event that triggers the SecondViewController to open
-(IBAction)onClick:(id)sender;

//the click event that changes the background color
-(IBAction)onChange:(id)sender;

//determines button that was pressed
-(IBAction)numberClicked:(id)sender;

//addition
-(IBAction)plusClicked:(id)sender;

//clear
-(IBAction)clearCalc:(id)sender;

//switch chnge
-(IBAction)onOff:(id)sender;

@end
