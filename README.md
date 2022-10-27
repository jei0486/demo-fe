
# docker cmd
docker pull ${DOCKER_IMAGE}:latest || true
docker build --cache-from ${DOCKER_IMAGE}:latest --tag ${DOCKER_IMAGE}:latest --tag ${DOCKER_IMAGE}:$CI_COMMIT_SHORT_SHA .
docker push ${DOCKER_IMAGE}:latest
docker push ${DOCKER_IMAGE}:$CI_COMMIT_SHORT_SHA

