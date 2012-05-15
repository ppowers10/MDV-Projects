//
//  ViewController.m
//  project3
//
//  Created by Patrick Powers on 5/14/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
    int num1 = 5;
    int num2 = 8;
    NSInteger addNumbers = [self addOne:num1 addTwo:num2];
    NSInteger compareNumbers = [self compareOne:num1 compareTwo:num2];
}
 
//Create a function called Add. This function will take two NSInteger or int types and return the result of an addition between these two.
-(NSInteger)addOne:(NSInteger)one addTwo:(NSInteger)two
{
    return (one + two);
}

//Create a function called Compare that takes two NSInteger values. Return true or false based on whether the values are equal.
-(BOOL)compareOne:(NSInteger)cOne compareTwo:(NSInteger)cTwo
{
    if (cOne == cTwo) {
        return true;
    }else {
        return false;
    }
}


//Create a function called Append. This function will take two NSStrings and return a new NSString containing the appended strings using an NSMutableString and the Append method.
    
    

//Call the Append function with two NSStrings. Capture the result and display a UIAlertView with the appended string using displayAlertWithString.
    
    

//Create a function called DisplayAlertWithString. This function will take as a parameter an NSString.
    
    

//Call the Add function passing in two integer values. Capture the return of this function into a variable.
    
    

//Bundle the returned integer into an NSNumber and then convert it to a NSString and pass it to the DisplayAlertWithString function.
    
    

//Give it any text for the title. The message will read, "The number is 00". Replace the 00 with the integer passed into the function.
    
    

//Call the Compare function with two integer values. If Compare returns true, display an UIAlertView both with the input values and the result using the DisplayAlertWithString function
    
    

//DisplayAlertWithString Function

//Take the passed in NSString and display it in the alert view

    

//Create an NSAlertView


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
