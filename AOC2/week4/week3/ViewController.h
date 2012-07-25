//
//  ViewController.h
//  week4
//
//  Created by Patrick Powers on 7/23/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AddEvent.h"

@interface ViewController : UIViewController <AddEventDelegate>
{
    @public
    IBOutlet UITextView *textView;
    IBOutlet UILabel *swipeLabelMain; 
    UISwipeGestureRecognizer *rightSwiper;
    NSString *eventString;

}

-(IBAction)onSave:(id)sender;

@end
