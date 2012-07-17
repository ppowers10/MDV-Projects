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
    IBOutlet UITextField *textField1;
    IBOutlet UIDatePicker *pickerView;
    NSString *getEvent;
    NSString *getDate;

    
}

//save and go back to event list
-(IBAction)onSave:(id)sender;

//close keyboard
-(IBAction)closeKeyboard:(id)sender;

//change date picker
-(IBAction)onChange:(id)sender;

@end
