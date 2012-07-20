//
//  ViewController.m
//  week3
//
//  Created by Patrick Powers on 7/15/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "AddEvent.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

-(IBAction)addEventClick:(id)sender
{
    //create the action that will change the first view to the second view controller
    AddEvent *addEventPage = [[AddEvent alloc] initWithNibName:@"AddEvent" bundle:nil];
    if (addEventPage != nil)
    {
        addEventPage.delegate = self;
        [self presentModalViewController:addEventPage animated:TRUE];
    }
}

//return the event string inputed in AddEvent view
-(void)DidClose:(NSString *)nameString
{
       textView.text = nameString; 
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
