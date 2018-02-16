# Installation Guide on MACOS

## Brew Installation

```shell
brew tap caskroom/versions
brew cask install java8
```

```
# ------------------------------------ #
# Proposition de script shell          #
#                                      #
# Author        : clunven              #
# Last Modified : 2016_03_01           #
# ------------------------------------ #


# ------------------------------------ #
# (1) Variables Environnements
# ------------------------------------ #

# Surcharge pour le prompt
export PS1="\[\033[31m\]\u\[\033[00m\]@\[\033[32m\]\h\[\033[00m\]:\[\033[34m\]\w\[\033[00m\]> "

# Couleurs dans le shell
export CLICOLOR=1
export LSCOLORS=dxfxcxdxbxegedabagacad

bold=$(tput bold)
underline=$(tput sgr 0 1)
reset=$(tput sgr0)
purple=$(tput setaf 171)
red=$(tput setaf 1)
green=$(tput setaf 76)
tan=$(tput setaf 3)
blue=$(tput setaf 38)

# ff4j
export FF4J_DEV=/Users/clun/dev/workspace-ff4j/

# PATH
export PATH=/opt/local/bin:/opt/local/sbin:$PATH

# ------------------------------------ #
# (2) Aliases
# ------------------------------------ #

# Afficher elements finder
alias showfc="defaults write com.apple.finder AppleShowAllFiles 1"
alias hidefc="defaults write com.apple.finder AppleShowAllFiles 0"

# Commande tree
alias tree="ls -R | grep ":" | sed -e 's/://' -e 's/[^-][^\/]*\//--/g' -e 's/^/ /' -e 's/-/|/'"

# Afficher contenu
alias ls="ls -la"
alias ll='ls -FGlAhp'

# Navigation                       
alias cd..='cd ../'                         
alias ..='cd ../'                           
alias ...='cd ../../'  
alias .3='cd ../../../' 
alias .4='cd ../../../../'  
alias .5='cd ../../../../../'  
alias .6='cd ../../../../../../'
alias ff4j="cd $FF4J_DEV/ff4j"


# Clear terminal display
alias c='clear'

# Chemin
alias path='echo -e ${PATH//:/\\n}'

alias dump='tee ~/Desktop/dumpTerminal.txt'
alias qfind="find . -name "

alias ttop="top -R -F -s 10 -o rsize"

alias myip='curl ip.appspot.com'                    # myip:         Public facing IP Address
alias netCons='lsof -i'                             # netCons:      Show all open TCP/IP sockets
alias cleanDS="find . -type f -name '*.DS_Store' -ls -delete"

# GIT
alias gita="git add -A"
alias gitp="git push origin master"
alias gitu="git pull"

alias make1mb='mkfile 1m ./1MB.dat'         # make1mb:      Creates a file of 1mb size (all zeros)
alias make5mb='mkfile 5m ./5MB.dat'         # make5mb:      Creates a file of 5mb size (all zeros)
alias make10mb='mkfile 10m ./10MB.dat'      # make10mb:     Creates a file of 10mb size (all zeros)

# ------------------------------------ #
# (3) Fonctions                        #
# ------------------------------------ #

# Affichage des textes
e_header() { 
	printf "\n${bold}${purple}==========  %s  ==========${reset}\n" "$@" 
}
e_arrow() { 
	printf "➜ $@\n"
}
e_success() { 
	printf "${green}✔ %s${reset}\n" "$@"
}
e_error() { 
	printf "${red}✖ %s${reset}\n" "$@"
}
e_warning() { 
	printf "${tan}➜ %s${reset}\n" "$@"
}
e_underline() { 
	printf "${underline}${bold}%s${reset}\n" "$@"
}
e_bold() { 
	printf "${bold}%s${reset}\n" "$@"
}
e_note() { 
	printf "${underline}${bold}${blue}Note:${reset}  ${blue}%s${reset}\n" "$@"
}


# Affiche contenu repertoire
cd() { 
  builtin cd "$@"; ll; 
}

# Recherche dans le man
mans () {
  man $1 | grep -iC2 --color=always $2 | less
}

# Creation rep et on rentre dedans
mcd () { 
  mkdir -p "$1" && cd "$1"; 
}

# Moves a file to the MacOS trash
trash () { 
  command mv "$@" ~/.Trash ; 
}

# To create a ZIP archive of a folder
zipf () { 
  zip -r "$1".zip "$1" ; 
}

# Find file under the current directory
ff () { 
	/usr/bin/find . -name "$@" ; 
}

# Find file whose name starts with a given string
ffs () { 
	/usr/bin/find . -name "$@"'*' ; 
}

# Find file whose name ends with a given string
ffe () { 
	/usr/bin/find . -name '*'"$@" ; 
}     

# List processes owned by my user:
my_ps() { 
	ps $@ -u $USER -o pid,%cpu,%mem,start,time,bsdtime,command ; 
}

# Afficher information principales
ii() {
   echo -e ""
   e_header "System Information"
   e_warning "Hostname:"
   echo -e "$HOSTNAME"
   echo -e ""
   e_warning "Additionnal information:$NC " ;uname -a
   echo -e ""
   e_warning "Users logged on:$NC " ; w -h
   echo -e ""
   e_warning "Current date :$NC " ; date
   echo -e ""
   e_warning "Machine stats :$NC " ; uptime
   echo -e ""
}

# search SpotLights
search () { 
	mdfind "kMDItemDisplayName == '$@'wc"; 
}

# git commit
gitm () { 
	git commit -m "$@" ; 
}


clear
echo "-------------------------------------------"
printf "Bienvenue ${blue}`whoami`${reset} sur ${red}`hostname`${reset}\n"
printf "Nous sommes le ${blue}`date +%x`${reset} il est ${blue}`date +%X`${reset}\n"
echo "-------------------------------------------"
```
