# GIT

## Revert a node
```git
git revert [COMMIT HASH]
git push
```

## Remove last node
```git
git reset --hard [PREVIOUS COMMIT HASH]
git push --force-with-lease
```

## Remove a node

### Method 1

```git 
   git checkout [PREVIOUS COMMIT HASH NODE IT WANTS TO BE DELETED]
   git checkout -b [NEW BRANCH NAME]
   git cherry-pick [NEXT COMMIT HASH NODE IT WANTS TO BE DELETED] // IT SHOULD BE DONE UNTIL THE END OF THE NODES HEAD
   ...
   git checkout master
   git reset --hard [PREVIOUS COMMIT HASH NODE IT WANTS TO BE DELETED]
   git merge [NEW BRANCH NAME]
   git push --force-with-lease
```

### Method 2

```git
git rebase -i [PREVIOUS COMMIT HASH NODE IT WANTS TO BE DELETED]
# In editor change pick to drop it wants to be deleted and save
git push --force [REMOTE NAME] [BRANCH NAME]
```

## Edit comment of commit
```git 
git rebase -i [PREVIOUS COMMIT HASH NODE IT WANTS TO BE EDITED]
# In editor change pick to reword it wants to be edited and save
# In editor modify the comment and save
git push --force [REMOTE NAME] [BRANCH NAME]
```
---

## remove cache
```
git rm --cached [FILENAME]
```
```
git rm -r --cached .
```
## Switched to a new branch
```
git checkout -b [NEW BRANCH]
```

## Set GIT_SSL_NO_VERIFY

```
git config http.sslVerify "false"
```
or
```
git config --global http.sslVerify false
```
## Global configuration 
```bash
git config --global --edit
```
## Get the Git commit count
```bash
git rev-list --all --count
```
## Create SSh key
```bash
ssh-keygen -t rsa -b 4096 -C "[YOUR_EMAIL]"
```
