

def call () {

     echo "Building the application... ${BRANCH_NAME}"
                    sh 'mvn package'


}
