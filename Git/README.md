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

## remove node:

1. Checkout the last usable commit.
   ```bash 
   git checkout [LAST_USABLE_COMMIT]
   ```
2. Create a new branch to work on.
   ```bash
   git checkout -b [NEW_BRANCH_NAME]
   ```
3. Run through commit 3.
   ```bash
   git cherry-pick [3TH_USABLE_COMMIT]
   ```
4. Run through commit 1
   ```bash
   git cherry-pick [2TH_USABLE_COMMIT]
   ```
5. Checkout master
   ```bash
   git checkout master
   ```
6. Reset master to last usable commit.
   ```bash
   git reset --hard [LAST_USABLE_COMMIT]
   ```
7. Merge our new branch onto master.
   ```bash
   git merge [NEW_BRANCH_NAME]
   ```
8. Push master to the remote repo.
   ```bash
   git push --hard origin master
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
