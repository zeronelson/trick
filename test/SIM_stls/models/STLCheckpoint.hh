/*
    PURPOSE: (Illustrate how to checkpoint STLs)
    LIBRARY_DEPENDENCIES: (
      (STLCheckpoint.o)
    )
*/

#ifndef STLCHECKPOINT_HH
#define STLCHECKPOINT_HH

#include <map>
#include <vector>
#include <list>
#include <deque>
#include <set>
#include <string>
#include <stack>
#include <queue>
#include <utility>


class SimpleWrapper {
    public:
        int a;
        std::vector<int> vec;
};

class UserClass {
    public:
        int a[5];
        long long b;
        std::string c;
        UserClass * d;
};

class STLCheckpoint {

    public:

        STLCheckpoint() ;
        int addData() ;
        int print() ;
        int test() ;

        bool dataJobRun;

        std::string name ;

        std::map< double , double > double_map ;
        std::map< std::string , int > string_key_map ;
        std::map< int , std::string > string_data_map ;
        std::map< std::string , std::string > string_map ;

        std::map< int , std::vector< int > > map_int_vector_int ;
        std::map< std::pair< int , int > , int > gcd ;
        std::map< std::pair< int , int > , std::pair< int , int > > map_pair_pair ;
        std::map< std::pair< int , int > , std::vector< int > > common_multiples ;

        std::multimap< int , int > int_multimap ;
        std::multimap< std::string , int > string_key_multimap ;
        std::multimap< int , std::string > string_data_multimap ;
        std::multimap< std::string , std::string > string_multimap ;

        std::vector< double > double_vector ;
        std::vector< std::string > string_vector ;

        std::list< short > short_list ;
        std::list< std::string > string_list ;

        std::deque< float > float_deque ;
        std::deque< std::string > string_deque ;

        std::set< int > int_set ;
        std::set< std::string > string_set ;
        std::set< std::vector<int> > vector_set;
        std::set< std::pair<std::string, int> > pair_set;    
        std::set<std::map<short,double>> nested_map_set;


        std::queue< std::vector<int> > vector_queue;


        std::multiset< long > long_multiset ;
        std::multiset< std::string > string_multiset ;
        std::multiset< std::pair< int,int > > pair_multiset ;
        std::multiset< std::vector< int > > vec_multiset ;


        std::stack< unsigned int > uint_stack ;
        std::stack< std::string > string_stack ;
        std::stack< std::vector<int> > stack_vector_int ;

        std::queue< int > int_queue ;
        std::queue< std::string > string_queue ;
        std::queue< std::vector<int> > queue_vector_int ;

        std::priority_queue< int > int_priority_queue ;
        std::priority_queue< std::string > string_priority_queue ;
        std::priority_queue< int , std::vector< int > , std::greater< int > > int_greater_priority_queue ;
        std::priority_queue< std::vector<int> > priority_queue_vector_int ;

        std::pair< int , int > int_pair ;
        std::pair< std::string , int > string_first_pair ;
        std::pair< int , std::string > string_second_pair ;
        std::pair< std::string , std::string > string_pair ;

        std::pair< int, std::vector<int> > int_vec_pair;
        std::pair< std::vector<int>, int > vec_int_pair;
        std::pair< std::vector<int>, std::vector<int> > vec_vec_pair;

        std::pair< int , std::pair< int, int > > int_pair_int_int ;
        std::pair< std::pair< int, int > , int > pair_int_int_int ;

        std::pair< std::pair< int, int > , std::pair< int, int > > pair_pair_pair ;

        std::vector< std::vector< double > > vector_vector_double ;
        std::vector< std::vector< std::vector< double > > > vector_vector_vector_double ;
        //std::vector< std::list< double >  > vector_list_double ;

        std::vector<UserClass> vec_user_simple;
        std::vector<SimpleWrapper> vec_user_defined;
        std::vector<SimpleWrapper *> vec_user_defined_ptr;


} ;

#endif

