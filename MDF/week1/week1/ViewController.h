//
//  ViewController.h
//  week1
//
//  Created by Patrick Powers on 8/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "SecondView.h"

@protocol ViewControllerDelegate <NSObject> 

@end

@class DataLayer;

@interface ViewController : UIViewController <UITableViewDelegate>

{
    @public
    DataLayer *dataLayer;
    IBOutlet UIButton *onEdit;
    IBOutlet UIButton *onSave;
    IBOutlet UITableView *tableView;
    
    NSString *currentState;
    NSString *stateString;
    
    NSMutableArray *statesArray;
    NSMutableArray *statesLocationArray;
    
}

-(IBAction)onEditClick:(id)sender;
-(IBAction)onSaveClick:(id)sender;

@property (strong, nonatomic) NSString *currentState;
@property (strong, nonatomic) NSString *stateString;


@end
