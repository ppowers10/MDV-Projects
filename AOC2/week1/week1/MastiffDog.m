//
//  MastiffDog.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "MastiffDog.h"
#import "DogClass.h"

@implementation MastiffDog

-(id)init
{
    if(self != nil)
    {
        [self setAttributes:Mastiff_Dog dogName:@"Doozer" pounds:120];
    }
    return self;
}
@end
