#!/bin/sh


DIR="workspace/packages/my-great-rest-service/redhat"
cd $DIR

ROOT=`pwd`
RELEASE=1
DATE=$(date --utc --date @$(git show -s --format=%ct || date +%s) +'%Y%m%d%H%M%S')
HASH=$(git show -s --format=git%h || echo 'local')
SNAPSHOT=$DATE$HASH
FILES=${1-'xroad-*.spec'}
CMD="-ba"

rm -rf ${ROOT}/RPMS/*

app_version=1.0.0

rpmbuild \
    --define "project_version $app_version" \
    --define "rel $RELEASE" \
    --define "snapshot .$SNAPSHOT" \
    --define "_topdir $ROOT" \
    -${CMD} SPECS/my-great-rest-service.spec
