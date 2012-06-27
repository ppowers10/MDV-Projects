//
//  BeagleDog.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "BeagleDog.h"
#import "DogClass.h"

@implementation BeagleDog

-(id)init
{
    if(self != nil)
    {
        [self setAttributes:Beagle_Dog dogName:@"Aspen" pounds:20];
    }
    return self;
}

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"The dog's name is %@ & weighs %i", name, lbs];
    return words;
}
@end
