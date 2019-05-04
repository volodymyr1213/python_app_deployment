node {
    properties([parameters([string(defaultValue: 'IP', description: 'Please give IP to build a site', name: 'IP', trim: true)])])
    stage("Clone repo") {
        git "https://github.com/volodymyr1213/flask-examples.git"
    }
    stage ("Install Requirements"){
        sh "scp-r * ec2-user@${ENV}:/tmp"
        sh "ssh ec2-user@${ENV} virtualenv /tmo/venv"
        sh "ssh ec2-user@${ENV} ./tmp/venv/activete"
        sh "ssh ec2-user@${ENV} sudo pip install -r /tmp/requirements.txt"
    }
    stage ("Start Python app")
        sh "ssh ec2-user@${ENV} python /tmp/01-hello-world/hello.py"

    }
}
