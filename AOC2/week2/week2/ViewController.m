//
//  ViewController.m
//  week2
//
//  Created by Patrick Powers on 7/8/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "SecondViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    //set defualt background to white
    self.view.backgroundColor = [UIColor whiteColor];
    
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
    newCalc.text = @"";
}

//number that is clicked and added to the label
-(IBAction)numberClicked:(id)sender
{
    UIButton *numButton = (UIButton*)sender;
    if (numButton != nil) {
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
