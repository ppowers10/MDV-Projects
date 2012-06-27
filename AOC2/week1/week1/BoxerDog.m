//
//  BoxerDog.m
//  week1
//
//  Created by Patrick Powers on 6/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "BoxerDog.h"
#import "DogClass.h"

@implementation BoxerDog

-(id)init
{
    if(self != nil)
    {
        [self setAttributes:Boxer_Dog dogName:@"Suzie" pounds:45];
    }
    return self;
}

-(NSString*)printLabel
{
    NSString *words = [[NSString alloc] initWithFormat:@"Pounds: %i, Name:%@", lbs, name];
    return words;
}
@end
