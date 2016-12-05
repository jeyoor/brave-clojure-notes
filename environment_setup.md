Simply using basic vim, bash jobs, and lein repl

Run lein repl from project root folder (having project.clj)

To reload everything:

user=> (load-file "src/fwpd/core.clj")
#'fwpd.core/filename
user=> (use 'fwpd.core)
nil

... hack hack hack ... 

user=> (load-file "src/fwpd/core.clj")
#'fwpd.core/filename
user=> (use 'fwpd.core)
nil

Defined "reload" shortcut for this

Added this vim plugin for markdown

https://github.com/plasticboy/vim-markdown
