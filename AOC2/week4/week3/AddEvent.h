//
//  AddEvent.h
//  week4
//
//  Created by Patrick Powers on 7/23/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

//create the delegate that can pass the events to the viewController
@protocol AddEventDelegate <NSObject>

-(void)DidClose:(NSString*)nameString;

@end

@interface AddEvent : UIViewController 
{
    @public
    IBOutlet UITextField *textField1;
    IBOutlet UIDatePicker *datePicked;
    NSString *currentDate;
    NSString *currentEvent;
    NSString *eventDateString;
    id<AddEventDelegate> delegate;
    
    IBOutlet UILabel *swipeLabelAdd; 
    UISwipeGestureRecognizer *leftSwiper;
}

@property (strong) id<AddEventDelegate> delegate;

//close keyboard
-(IBAction)closeKeyboard:(id)sender;

//minimun date and determine date that is set
-(IBAction)onChange:(id)sender;


@end


