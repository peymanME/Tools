# GIT

## remove node:
``` bash 
# Checkout the last usable commit.
1. >git checkout [LAST_USABLE_COMMIT]

# Create a new branch to work on.
2. >git checkout -b [NEW_BRANCH_NAME]

# Run through commit 3.
3. >git cherry-pick [3TH_USABLE_COMMIT]

# Run through commit 1
4. >git cherry-pick [2TH_USABLE_COMMIT]

# Checkout master
5. >git checkout master

# Reset master to last usable commit.
6. >git reset --hard [LAST_USABLE_COMMIT]

# Merge our new branch onto master.
7. >git merge [NEW_BRANCH_NAME]

# Push master to the remote repo.
8. >git push --hard origin master
   
```
## remove cache
```
git rm --cached [FILENAME]
```
## Switched to a new branch
```
git checkout -b [NEW BRANCH]
```
