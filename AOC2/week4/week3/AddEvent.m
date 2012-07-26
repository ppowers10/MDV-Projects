//
//  AddEvent.m
//  week4
//
//  Created by Patrick Powers on 7/23/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "AddEvent.h"
#import "ViewController.h"

@interface AddEvent ()

@end

@implementation AddEvent

@synthesize delegate;

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
    
    //set up the left swipe gesture 
    leftSwiper = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(OnLeft:)];
    leftSwiper.direction = UISwipeGestureRecognizerDirectionLeft;
    [swipeLabelAdd addGestureRecognizer:leftSwiper];

}

//use the left swipe gesture to grab the event text and date and return it to the ViewController
-(void)OnLeft:(UISwipeGestureRecognizer*)recognizer
{
    currentEvent = textField1.text;
    eventDateString = [[NSString alloc] initWithFormat:@"%@ \n %@ \n", currentEvent, currentDate];
    [delegate DidClose:eventDateString];
    [self dismissModalViewControllerAnimated:TRUE];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}


//closes the keyboard when opened from the Event textfield
-(IBAction)closeKeyboard:(id)sender;
{
    [textField1 resignFirstResponder];
}

//allows for a minimum date of today and saves the date into a variable
-(IBAction)onChange:(id)sender
{
    UIDatePicker *datepicker = (UIDatePicker*)sender;
    if (datepicker != nil) {
        datepicker.minimumDate = [NSDate date];
        NSDate *dateTime = datepicker.date;
        NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
        if (dateFormatter != nil) {
            [dateFormatter setDateFormat:@"MMM d, yyyy hh:mm aaa"];
            NSString *setDate = [[NSString alloc] initWithFormat:@"%@", [dateFormatter stringFromDate:dateTime]];
            currentDate  = setDate; 
        }
    }
}


- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
