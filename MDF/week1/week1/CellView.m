//
//  CellView.m
//  week1
//
//  Created by Patrick Powers on 8/28/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "CellView.h"

@implementation CellView

//allow accessability from the ViewController
@synthesize stateLabel;
@synthesize locationLabel;

- (id)initWithStyle:(UITableViewCellStyle)style reuseIdentifier:(NSString *)reuseIdentifier
{
    self = [super initWithStyle:style reuseIdentifier:reuseIdentifier];
    if (self) {
        // Initialization code
    }
    return self;
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated
{
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

@end
