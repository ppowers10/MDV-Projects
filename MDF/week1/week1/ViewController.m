//
//  ViewController.m
//  week1
//
//  Created by Patrick Powers on 8/26/12.
//  Copyright (c) 2012 Full Sail University. All rights reserved.
//

#import "ViewController.h"
#import "CellView.h"
#import "SecondView.h"

@interface ViewController ()

@end

@implementation ViewController

//@synthesize delegate1;
@synthesize currentState;
@synthesize stateString;

- (void)viewDidLoad
{
   // dataLayer = [[DataLayer alloc] init];
   // [dataLayer getStates];
   
    //create array of states
   statesArray =  [[NSMutableArray alloc] initWithObjects:
                    @"Alabama",
                    @"Alaska",
                    @"Arizona",
                    @"Arkansas",
                    @"California",
                    @"Colorado",
                    @"Connecticut",
                    @"Delaware",
                    @"District of Columbia",
                    @"Florida",
                    @"Georgia",
                    @"Hawaii",
                    @"Idaho",
                    @"Illinois",
                    @"Indiana",
                    @"Iowa",
                    @"Kansas",
                    @"Kentucky",
                    @"Louisiana",
                    @"Maine",
                    @"Maryland",
                    @"Massachusetts",
                    @"Michigan",
                    @"Minnesota",
                    @"Mississippi",
                    @"Missouri",
                    @"Montana",
                    @"Nebraska",
                    @"Nevada",
                    @"New Hampshire",
                    @"New Jersey",
                    @"New Mexico",
                    @"New York",
                    @"North Carolina",
                    @"North Dakota",
                    @"Ohio",
                    @"Oklahoma",
                    @"Oregon",
                    @"Pennsylvania",
                    @"Rhode Island",
                    @"South Carolina",
                    @"South Dakota",
                    @"Tennessee",
                    @"Texas",
                    @"Utah",
                    @"Vermont",
                    @"Virginia",
                    @"Washington",
                    @"West Virginia",
                    @"Wisconsin",
                    @"Wyoming",
                    nil];
    //create array of locations for the states
    statesLocationArray =  [[NSMutableArray alloc] initWithObjects:
                    @"South East",
                    @"West",
                    @"Southwest",
                    @"South East",
                    @"West",
                    @"West",
                    @"North East",
                    @"North East",
                    @"North East",
                    @"South East",
                    @"South East",
                    @"West",
                    @"West",
                    @"Mid West",
                    @"Mid West",
                    @"Mid West",
                    @"Mid West",
                    @"South East",
                    @"South East",
                    @"North East",
                    @"North East",
                    @"North East",
                    @"Mid West",
                    @"West",
                    @"South East",
                    @"Mid West",
                    @"West",
                    @"Mid West",
                    @"Southwest",
                    @"North East",
                    @"North East",
                    @"Southwest",
                    @"North East",
                    @"South East",
                    @"Mid West",
                    @"Mid West",
                    @"Southwest",
                    @"West",
                    @"North East",
                    @"North East",
                    @"South East",
                    @"South Dakota",
                    @"South East",
                    @"Southwest",
                    @"West",
                    @"North East",
                    @"South East",
                    @"West",
                    @"South East",
                    @"Mid West",
                    @"Mid West",
                    nil];
     
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPhone) {
        return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
    } else {
        return YES;
    }
}

//when user clicks "Edit" the delete edit appears and onSave/"Save" button appears
-(IBAction)onEditClick:(id)sender
{
    [tableView setEditing:true];
    [onEdit setHidden:true];
    [onSave setHidden:false];
}

//when user clicks on "Save" the editing mode is removed and onEdit/"Edit" button appears
-(IBAction)onSaveClick:(id)sender
{
    [tableView setEditing:false];
    [onEdit setHidden:false];
    [onSave setHidden:true];
    
}

//defines the number of rows based on the array
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [statesArray count];
}

//create the ability to edit the table view by deleting certain row
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath
{
    //check if editing syle is on to delete
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        //remove the particular row
        [statesArray removeObjectAtIndex:indexPath.row];
        //create the animation to remove the row
        [tableView deleteRowsAtIndexPaths:[NSMutableArray arrayWithObject:indexPath]  withRowAnimation:true];
    }
}

//fill in each row with the custom table cell and fill it with the text
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    
    CellView *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if (cell == nil) 
    {
        //cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:CellIdentifier];
        NSArray* views = [[NSBundle mainBundle] loadNibNamed:@"CellView" owner:nil options:nil];
        
        for (UIView *view in views) {
            if ([view isKindOfClass:[CellView class]]) {
                cell = (CellView*)view;
                cell.stateLabel.text = [statesArray objectAtIndex:indexPath.row];
                cell.locationLabel.text = [statesLocationArray objectAtIndex:indexPath.row];
           }
        }
    
    }
    
    //cell.textLabel.text = [statesArray objectAtIndex:indexPath.row];
    //[[dataLayer getStates] objectAtIndex:indexPath.row];
            
    return cell;
}

//allows for the particular selection of a row
- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath
{
    
    NSLog(@"State = %@", [statesArray objectAtIndex:indexPath.row]);
    
  /*  NSInteger row = [indexPath row];
    
    if (self.glossaryDetailViewController == nil)
    {
        GlossaryDetailViewController *aGlossaryDetail = [[GlossaryDetailViewController alloc] initWithNibName:@"GlossaryDetailViewController" bundle:nil];
        self.glossaryDetailViewController = aGlossaryDetail;
        [aGlossaryDetail release];
    }
    
    glossaryDetailViewController.glossaryDetailItem = [glossaryArray objectAtIndex:row];
    
    [self.navigationController pushViewController:self.glossaryDetailViewController animated:YES];
   */
    //create the action that will change the first view to the second view controller
    SecondView *addSecondView = [[SecondView alloc] initWithNibName:@"SecondView" bundle:nil];
    if (addSecondView != nil)
    {
        NSString *currentState = [statesArray objectAtIndex:indexPath.row];
        NSString *stateString = [[NSString alloc] initWithFormat:@"You need to visit %@", currentState];
        addSecondView.stateView = currentState;
        addSecondView.textView = stateString;
       // [delegate1 DidOpen:stateString];
        addSecondView.delegate = self;
        [self presentModalViewController:addSecondView animated:TRUE];
    }
    
}

@end
