//
//  SecondView.h
//  week1
//
//  Created by Patrick Powers on 8/27/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ViewController.h"


@protocol SecondViewDelegate <NSObject>

@end

@interface SecondView : UIViewController
{
    @public
    IBOutlet UIButton *onBack;
    IBOutlet UILabel *stateView;
    IBOutlet UILabel *textView;
}

@property (strong) UILabel *stateView;
@property (strong) UILabel *textView;
@property (strong) id<SecondViewDelegate> delegate;

-(IBAction)onBack:(id)sender;

@end
