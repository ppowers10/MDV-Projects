//
//  CellView.h
//  week1
//
//  Created by Patrick Powers on 8/28/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface CellView : UITableViewCell
{
    //create outlets for the Labels on the custom cell view.  One for each string.
    IBOutlet UILabel *stateLabel;
    IBOutlet UILabel *locationLabel;
}

//allow accessability from the ViewController
@property (strong, nonatomic)IBOutlet UILabel *stateLabel;
@property (strong, nonatomic)IBOutlet UILabel *locationLabel;

@end
