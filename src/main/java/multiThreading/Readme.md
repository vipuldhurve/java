# Multi Threading
Why we need multi threading?
- Performance(Parellelism) : We can create an illusion of multile tasks executing in parallel uding just a single core.
- Responsiveness(Concurrency) : Applications with user interface like watching movie & increasing volume simultaneously.

### Concurrency - Multitasking
Concurrency allows different parts of progam to make progress independently,
often leading to better resource utilization and improved performance.

## Process/Context - Instance of application
- A process consists of
  - Metadata like id, priority etc.
  - Files
  - Heap
  - Code
  - Atleast one thread called <b>Main Thread</b>
- A process is a unit of execution or instance of an application.
- Each process is completely isolated from other process that runs on system.
- A process has a heap memory.
- A process can have multiple threads

## Thread
- A thread consists of
  - thread stack : where local variables are stored and functions are executed
  - instruction pointer : Address of the next instruction to execute
  
## Context Switch
- Stop thread 1
- Schedule thread 1 out
- Schedule thread 2 in
- Start thread 2

### Thrashing
Spending more time in management(context switches) than real productive work

### Thread Shceduling
- First Come First Serve
  - if a long thread arrives first it can make UI threads unresposive leading to <b>Starvation</b>.
- Shortest Job First 
  -  If we keep scheduling shorter tasks(like UI threads) first the longer threads that has computations will never be executed.
- OS divides the time into moderately sized pieces called <b>Epoch</b>.
- Dynamic Priority = Static Priority + Bonus
- Using Dynamic priority OS will give preference to interactive threads and will give preference to threads that did not complete in the last epoch preventing Starvation.

### When to prefer Multi Threading
- Prefer if tasks share a lot of data.
- Threads are much faster to create and destroy
- Switching b/w threads in same process is faster(short context switches).

### When to prefer Multi Process
- security and stability of higher priority as thread share data and a thread can bring down entire app.
- tasks are unrrelated to each other
