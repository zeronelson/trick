This directory (will) contain documentation and examples for Trick developers to learn to use clang libraries effectively.

Why:

Trick uses clang in a very unique way, so existing clang examples in the wild aren't as useful to us. We need our own.
Trick devs don't know clang very well and may not be using it to its full strengths
Clang tools may be useful in other areas of Trick besides ICG

Preliminary Details:

Clang has different approaches for writing tools outlined in their documentation:
libclang, plugins, and libtooling.

Currently both plugins and libtooling most closely resemble ICG, but they have added a lot of features and strongly
encourage the use of the FrontendActions class and AST matchers, neither of which we currently use.

Another possibility is no longer having to create our own compiler instance, and all the pain and suffering that comes with it:
See this blog post:

https://eli.thegreenplace.net/2014/05/01/modern-source-to-source-transformation-with-clang-and-libtooling

And clang docs:
https://clang.llvm.org/docs/Tooling.html