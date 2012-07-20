//
//  AddEvent.h
//  week3
//
//  Created by Patrick Powers on 7/15/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

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
}

@property (strong) id<AddEventDelegate> delegate;

//save and go back to event list
-(IBAction)onSave:(id)sender;

//close keyboard
-(IBAction)closeKeyboard:(id)sender;

//minimun date
-(IBAction)onChange:(id)sender;


@end


