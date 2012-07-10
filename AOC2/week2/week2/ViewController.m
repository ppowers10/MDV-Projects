//
//  ViewController.m
//  week2
//
//  Created by Patrick Powers on 7/8/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "SecondViewController.h"
#import <QuartzCore/QuartzCore.h>

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    //set defualt background to white
    self.view.backgroundColor = [UIColor whiteColor];
    switch1.on = true;
    calc.layer.cornerRadius =8.0;
    calc.layer.borderColor = [UIColor grayColor].CGColor;
    calc.layer.borderWidth = 1.0;

    
}


-(IBAction)onClick:(id)sender
{
    //create the action that will change the first view to the second view controller
    SecondViewController *infoPage = [[SecondViewController alloc] initWithNibName:@"SecondView" bundle:nil];
    if (infoPage != nil)
    {
        [self presentModalViewController:infoPage animated:TRUE];
    }
}

//clear the label
-(IBAction)clearCalc:(id)sender;
{
    if (switch1.on == true) {
        newCalc.text = @"";
    }
    else if (switch1.on == false)
    {
        NSLog(@"Input not currently working");
    }
}

//number that is clicked and added to the label and checks to make sure switch is on. If off, calculator does not work.
-(IBAction)numberClicked:(id)sender
{
    if (switch1.on == true) {
   
        UIButton *numButton = (UIButton*)sender;
        if (numButton != nil) {
            //type in numbers and continue to add to those numbers within the "string"
            if (numButton.tag == 0) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@0", calc.text];
            }
            else if (numButton.tag == 1) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@1", calc.text];
            }
            else if (numButton.tag == 2) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@2", calc.text];
            }
            else if (numButton.tag == 3) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@3", calc.text];
            }
            else if (numButton.tag == 4) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@4", calc.text];
            }
            else if (numButton.tag == 5) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@5", calc.text];
            }
            else if (numButton.tag == 6) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@6", calc.text];
            }
            else if (numButton.tag == 7) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@7", calc.text];
            }
            else if (numButton.tag == 8) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@8", calc.text];
            }
            else if (numButton.tag == 9) {
                newCalc.text = [[NSString alloc] initWithFormat:@"%@9", calc.text];
            }
        }
    }
    else if (switch1.on == false)
    {
        NSLog(@"Input not currently working");
    }
}

//gets the text value and stores it in a variable to calculate with future number
-(IBAction)plusClicked:(id)sender
{
    if (switch1.on == true) {
        x = [calc.text intValue];
        calc.text = @"";
    }
    else if (switch1.on == false)
    {
        NSLog(@"Input not currently working");
    }

}

//equal button
-(IBAction)equalClicked:(id)sender
{
    if (switch1.on == true) {
        result = x + [calc.text intValue];
        calc.text = [NSString stringWithFormat:@"%d", result];
    }
    else if (switch1.on == false)
    {
        NSLog(@"Input not currently working");
    }
}


//segmented control for background colors
-(IBAction)onChange:(id)sender
{
    UISegmentedControl *segmentControl = (UISegmentedControl*) sender;
    if (segmentControl != nil)
    {
        //get the index number for the selected segment
        int selectedIndex = segmentControl.selectedSegmentIndex;
        
        //set the background color based on the selected segment
        if (selectedIndex == 0) {
            self.view.backgroundColor = [UIColor whiteColor];
        }
        else if (selectedIndex == 1) {
            self.view.backgroundColor = [UIColor blueColor];
        }
        else if (selectedIndex == 2) {
            self.view.backgroundColor = [UIColor greenColor];
        }
    }
}

//switch to clear
-(IBAction)switchOn:(id)sender
{
    calc.text = @"";
    x = 0;
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
