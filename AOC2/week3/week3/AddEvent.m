//
//  AddEvent.m
//  week3
//
//  Created by Patrick Powers on 7/15/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "AddEvent.h"

@interface AddEvent ()

@end

@implementation AddEvent

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view.
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(keyboardWillShow:) name:UIKeyboardWillShowNotification object:nil];
    
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(keyboardWillHide:) name:UIKeyboardWillHideNotification object:nil];
}

-(void) keyboardWillShow:(NSNotification *)notification 
{
    
}

-(void) keyboardWillHide:(NSNotification *)notification 
{
    
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}



-(IBAction)closeKeyboard:(id)sender;
{
    [textField1 resignFirstResponder];
}

-(IBAction)onChange:(id)sender
{
    UIDatePicker *datepicker = (UIDatePicker*)sender;
    if (datepicker != nil) {
        NSDate *dateTime = datepicker.date;
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        if (dateFormatter != nil) {
            [dateFormatter setDateFormat:@"MMM d, yyyy hh:mm aaa"];
            NSString *setDate = [[NSString alloc] initWithFormat:@"%@", [dateFormatter stringFromDate:dateTime]];
            getDate  = setDate; 
        }
    }    
}

//save and go back to event list
-(IBAction)onSave:(id)sender
{
    getEvent = textField1.text;
    [self dismissModalViewControllerAnimated:TRUE];
    NSLog(@"%@", getEvent);
    NSLog(@"%@", getDate);
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
