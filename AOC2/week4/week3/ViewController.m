//
//  ViewController.m
//  week4
//
//  Created by Patrick Powers on 7/23/12.
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
    
    rightSwiper = [[UISwipeGestureRecognizer alloc] initWithTarget:self action:@selector(OnRight:)];
    rightSwiper.direction = UISwipeGestureRecognizerDirectionRight;
    [swipeLabelMain addGestureRecognizer:rightSwiper];
    
    NSUserDefaults *defualts = [NSUserDefaults standardUserDefaults];
    if (defualts != nil) {
        NSString *eventStringView = [defualts objectForKey:@"events"];
        
        textView.text = eventStringView;
    }
    
    if ([textView.text isEqualToString:@""]) {
        textView.text = @"All the events go here...";
    }
}

-(void)OnRight:(UISwipeGestureRecognizer*)recognizer
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
    //check to see if the main view has any events listed
    if ([textView.text isEqualToString:@"All the events go here..."]) {
        textView.text = nameString; 
    }  
    //updated previously saved event with new event below
    else {
        eventString = textView.text;
        textView.text = [eventString stringByAppendingString:nameString];
    }
}

-(IBAction)onSave:(id)sender
{
    NSUserDefaults *defualts = [NSUserDefaults standardUserDefaults];
    if (defualts != nil) {
        NSString *eventStringView = textView.text;
        
        [defualts setObject:eventStringView forKey:@"events"];
        
        [defualts synchronize];
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
