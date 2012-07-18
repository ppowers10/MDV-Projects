//
//  AddEvent.h
//  week3
//
//  Created by Patrick Powers on 7/15/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface AddEvent : UIViewController <UIPickerViewDelegate, UIPageViewControllerDataSource>
{
    @public
    IBOutlet UITextField *textField1;
    IBOutlet UIDatePicker *datePicked;
    NSString *currentEvent;
    NSString *currentDate;

}

//save and go back to event list
-(IBAction)onSave:(id)sender;

//close keyboard
-(IBAction)closeKeyboard:(id)sender;

//minimun date
-(IBAction)onChange:(id)sender;

@end
