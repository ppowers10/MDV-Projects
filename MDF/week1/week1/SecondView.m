//
//  SecondView.m
//  week1
//
//  Created by Patrick Powers on 8/27/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "SecondView.h"
#import "ViewController.h"

@interface SecondView ()

@end

@implementation SecondView

@synthesize delegate;
@synthesize stateView;
@synthesize textView;

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
    //stateView.text = currentState;
    //textView.text = stateString;
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

//save and go back to event list
-(IBAction)onBack:(id)sender
{

    [self dismissModalViewControllerAnimated:TRUE];
    
}



@end
