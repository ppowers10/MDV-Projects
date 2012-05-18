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
//Call the Add function passing in two integer values. Capture the return of this function into a variable.
    NSInteger addNumbers = [self addOne:num1 addTwo:num2];
//Bundle the returned integer into an NSNumber and then convert it to a NSString and pass it to the DisplayAlertWithString function.
    NSNumber *numberConvertedNumber = [[NSNumber alloc] initWithInt:addNumbers];
    NSString *myString = [numberConvertedNumber stringValue];
    NSInteger compareNumbers = [self compareOne:num1 compareTwo:num2];
    NSString *appStrings = [self appendOne:@"This is string one." appendTwo:@" This is string two."];

//Call the Append function with two NSStrings. Capture the result and display a UIAlertView with the appended string using displayAlertWithString.
    UIAlertView *alertAppend = [[UIAlertView alloc] initWithTitle:@"Appended String" message:appStrings delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil, nil];
    if (alertAppend != nil)
    {
        [alertAppend show];
    }
    [self displayAlertWithString:myString];
    //Call the Compare function with two integer values. If Compare returns true, display an UIAlertView both with the input values and the result using the DisplayAlertWithString function
    NSString *numbersNotEqual = [[NSString alloc] initWithFormat:@"%d and %d are not equal.", num1, num2];
    NSString *numbersEqual = [[NSString alloc] initWithFormat:@"%d and %d are equal.", num1, num2];
    if (compareNumbers == 0) {
        
        UIAlertView *compareFalse = [[UIAlertView alloc] initWithTitle:@"Not Equal" message:numbersNotEqual delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil, nil];
        [compareFalse show];
    }else{
        UIAlertView *compareTrue = [[UIAlertView alloc] initWithTitle:@"Equal" message:numbersEqual delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil, nil];
        [compareTrue show];
    }
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

-(NSString*)appendOne:(NSString*)aOne appendTwo:(NSString*)aTwo
{
    NSMutableString *appendedStrings = [[NSMutableString alloc] initWithString:@""];
        [appendedStrings appendString:aOne];
        [appendedStrings appendString:aTwo];
    return appendedStrings;
}

//Create a function called DisplayAlertWithString. This function will take as a parameter an NSString.
-(NSString*)displayAlertWithString:(NSString*)displayAlertWithString
{
    //Give it any text for the title. The message will read, "The number is 00". Replace the 00 with the integer passed into the function.
    NSString *messageNumber = [[NSString alloc] initWithFormat:@"This number is %@", displayAlertWithString];
    //DisplayAlertWithString Function
    //Take the passed in NSString and display it in the alert view
    UIAlertView *alertNumber = [[UIAlertView alloc] initWithTitle:@"Number" message:messageNumber delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil, nil];
    if (alertNumber != nil)
    {
        [alertNumber show];
    }
}

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
