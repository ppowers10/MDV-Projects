//
//  ViewController.h
//  week3
//
//  Created by Patrick Powers on 7/15/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AddEvent.h"

@interface ViewController : UIViewController <AddEventDelegate>
{
    @public
    IBOutlet UITextView *textView;
    NSString *eventString;

}

//links to AddEvent view
-(IBAction)addEventClick:(id)sender;


@end
